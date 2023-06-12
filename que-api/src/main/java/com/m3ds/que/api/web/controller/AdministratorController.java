package com.m3ds.que.api.web.controller;


import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.account.entity.form.AdministratorForm;
import com.m3ds.que.account.entity.form.AdministratorLoginForm;
import com.m3ds.que.account.entity.form.AdministratorQueryForm;
import com.m3ds.que.account.entity.param.AdministratorQueryParam;
import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.account.entity.vo.AdministratorVo;
import com.m3ds.que.account.service.IAdministratorService;
import com.m3ds.que.account.util.JwtUtils;
import com.m3ds.que.api.annotation.Login;
import com.m3ds.que.common.core.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 管理员controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/account")
public class AdministratorController {
    @Resource
    private IAdministratorService administratorServiceImpl;
    @Resource
    private JwtUtils jwtUtils;

    /**
     * @param loginForm 管理员登录的账号和密码
     * @return com.m3ds.que.common.core.vo.Result 包含token
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody @Valid AdministratorLoginForm loginForm) {
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", loginForm.getUserName());
        queryWrapper.eq("password", DigestUtil.md5Hex(loginForm.getPassword()));
        Administrator administrator = administratorServiceImpl.getOne(queryWrapper);
        if (administrator == null) {
            return Result.fail("用户名或密码错误！");
        }
        return Result.success(jwtUtils.generateToken(administrator.getId()));
    }

    /**
     * @param userId token解密后产生的userId
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 查询当前登陆的管理员
     */
    @Login
    @GetMapping("/getSelf")
    public Result getSelf(@RequestAttribute String userId) {
        Administrator administrator = administratorServiceImpl.getById(userId);
        if (administrator == null) {
            return Result.fail("没有找到对应数据！");
        }
        return Result.success(new AdministratorVo(administrator));
    }

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询管理员
     */
    @ApiOperation(value = "查询管理员", notes = "根据id查找管理员")
    @ApiImplicitParam(paramType = "path", name = "id", value = "管理员id", required = true, dataType = "string")
    @Login
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        Administrator administrator = administratorServiceImpl.getById(id);
        if (administrator == null) {
            return Result.fail("没有找到对应数据！");
        }
        return Result.success(new AdministratorVo(administrator));
    }

    /**
     * @param administratorQueryForm 管理员查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询参数分页查询管理员
     */
    @ApiOperation(value = "分页查询管理员", notes = "带参数分页查询管理员")
    @ApiImplicitParam(paramType = "body", name = "administratorQueryForm", value = "管理员的实体", required = true, dataType = "AdministratorQueryForm")
    @PostMapping("/conditions")
    @Login
    public Result conditions(@RequestBody @Valid AdministratorQueryForm administratorQueryForm) {
        QueryWrapper<Administrator> queryWrapper = administratorQueryForm.toParam(AdministratorQueryParam.class).build();
        Page page = administratorServiceImpl.page(administratorQueryForm.getPage(), queryWrapper);
        return Result.success(page.setRecords((List) page.getRecords().stream().map(t -> new AdministratorVo((Administrator) t)).collect(Collectors.toList())));
    }

    /**
     * @param administratorQueryParam 管理员查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询管理员
     */
    @ApiOperation(value = "带查询条件查询管理员", notes = "带查询条件查询管理员")
    @ApiImplicitParam(paramType = "query", name = "administratorQueryParam", value = "管理员的实体", required = true, dataType = "AdministratorQueryParam")
    @GetMapping
    @Login
    public Result query(AdministratorQueryParam administratorQueryParam) {
        QueryWrapper<Administrator> queryWrapper = administratorQueryParam.build();
        return Result.success((administratorServiceImpl.list(queryWrapper).stream().map(AdministratorVo::new)).collect(Collectors.toList()));
    }

    /**
     * @param administratorForm 要保存的管理员对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存管理员
     */
    @ApiOperation(value = "保存管理员", notes = "保存管理员")
    @ApiImplicitParam(paramType = "body", name = "administratorForm", value = "管理员的实体", required = true, dataType = "AdministratorForm")
    @PostMapping
    @Login
    public Result save(@RequestBody @Valid AdministratorForm administratorForm, String userId) {
        Administrator administrator = administratorForm.toPo(Administrator.class);
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",administrator.getUserName());
        int count = administratorServiceImpl.count(queryWrapper);
        //有相同username的话，就返回false
        if (count > 0){
            return Result.fail("用户名已被占用");
        }
        //保存时应对密码加密
        administrator.setPassword(DigestUtil.md5Hex(administrator.getPassword()));
        administratorServiceImpl.save(administrator);
        return Result.success();
    }

    /**
     * @param administratorForm 要更新的管理员对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新管理员
     */
    @ApiOperation(value = "更新管理员", notes = "根据管理员id更新管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "要修改的管理员id", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "body", name = "administratorForm", value = "管理员实体", required = true, dataType = "AdministratorForm")
    })
    @PutMapping(value = "/{id}")
    @Login
    public Result update(@PathVariable String id, @RequestBody AdministratorForm administratorForm) {
        Administrator administrator = administratorForm.toPo(Administrator.class);
        administrator.setId(id);
        //不能更新用户名和密码,所以设为空
        administrator.setUserName(null);
        administrator.setPassword(null);
        administratorServiceImpl.updateById(administrator);
        return Result.success();
    }

    /**
     * @param id 要删除的管理员id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个管理员
     */
    @ApiOperation(value = "删除一个管理员", notes = "根据id来删除一个管理员")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要删除的管理员id", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    @Login
    public Result delete(@PathVariable String id) {
        administratorServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param ids 管理员的id列表
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:57
     * @description 批量删除管理员
     */
    @ApiOperation(value = "批量删除管理员", notes = "根据多个id批量删除管理员")
    @ApiImplicitParam(paramType = "body", name = "ids", value = "要删除的管理员id们", required = true, dataType = "string")
    @DeleteMapping("/del/batch")
    @Login
    public Result deleteBatch(@RequestBody List<String> ids) {
        administratorServiceImpl.removeByIds(ids);
        return Result.success();
    }
}
