package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.account.entity.form.AdministratorForm;
import com.m3ds.que.account.entity.form.AdministratorQueryForm;
import com.m3ds.que.account.entity.param.AdministratorQueryParam;
import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.account.entity.vo.AdministratorVo;
import com.m3ds.que.account.service.IAdministratorService;
import com.m3ds.que.common.core.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询管理员
     */
    @ApiOperation(value = "查询管理员", notes = "根据id查找管理员")
    @ApiImplicitParam(paramType = "path", name = "id", value = "管理员id", required = true, dataType = "string")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(new AdministratorVo(administratorServiceImpl.getById(id)));
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
    public Result search(@Valid @RequestBody AdministratorQueryForm administratorQueryForm) {
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
    public Result query(@RequestParam AdministratorQueryParam administratorQueryParam) {
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
    public Result save(@RequestBody AdministratorForm administratorForm) {
        Administrator administrator = administratorForm.toPo(Administrator.class);
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
    public Result update(@PathVariable String id, @Valid @RequestBody AdministratorForm administratorForm) {
        Administrator administrator = administratorForm.toPo(Administrator.class);
        administrator.setId(id);
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
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        administratorServiceImpl.removeByIds(ids);
        return Result.success();
    }
}
