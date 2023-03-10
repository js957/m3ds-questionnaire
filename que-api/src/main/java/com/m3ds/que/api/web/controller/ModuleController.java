package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.center.entity.form.ModuleForm;
import com.m3ds.que.center.entity.form.ModuleQueryForm;
import com.m3ds.que.center.entity.param.ModuleQueryParam;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleVo;
import com.m3ds.que.center.service.IModuleService;
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
 * 问卷模块controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/psyquestioner/module")
public class ModuleController {
    @Resource
    private IModuleService moduleServiceImpl;

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询问卷模块
     */
    @ApiOperation(value = "查询问卷模块", notes = "根据id查找问卷模块")
    @ApiImplicitParam(paramType = "path", name = "id", value = "问卷模块id", required = true, dataType = "string")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(new ModuleVo(moduleServiceImpl.getById(id)));
    }

    /**
     * @param moduleQueryForm 问卷模块查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询参数分页查询问卷模块
     */
    @ApiOperation(value = "分页查询问卷模块", notes = "带参数分页查询问卷模块")
    @ApiImplicitParam(paramType = "body", name = "moduleQueryForm", value = "问卷模块的实体", required = true, dataType = "ModuleQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody ModuleQueryForm moduleQueryForm) {
        QueryWrapper<Module> queryWrapper = moduleQueryForm.toParam(ModuleQueryParam.class).build();
        Page page = moduleServiceImpl.page(moduleQueryForm.getPage(), queryWrapper);
        return Result.success(page.setRecords((List) page.getRecords().stream().map(t -> new ModuleVo((Module) t)).collect(Collectors.toList())));
    }

    /**
     * @param moduleQueryParam 问卷模块查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询问卷模块
     */
    @ApiOperation(value = "带查询条件查询问卷模块", notes = "带查询条件查询问卷模块")
    @ApiImplicitParam(paramType = "query", name = "moduleQueryParam", value = "问卷模块的实体", required = true, dataType = "ModuleQueryParam")
    @GetMapping
    public Result query(@RequestParam ModuleQueryParam moduleQueryParam) {
        QueryWrapper<Module> queryWrapper = moduleQueryParam.build();
        return Result.success((moduleServiceImpl.list(queryWrapper).stream().map(ModuleVo::new)).collect(Collectors.toList()));
    }

    /**
     * @param moduleForm 要保存的问卷模块对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存问卷模块
     */
    @ApiOperation(value = "保存问卷模块", notes = "保存问卷模块")
    @ApiImplicitParam(paramType = "body", name = "moduleForm", value = "问卷模块的实体", required = true, dataType = "ModuleForm")
    @PostMapping
    public Result save(@RequestBody ModuleForm moduleForm) {
        Module module = moduleForm.toPo(Module.class);
        moduleServiceImpl.save(module);
        return Result.success();
    }

    /**
     * @param moduleForm 要更新的问卷模块对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新问卷模块
     */
    @ApiOperation(value = "更新问卷模块", notes = "根据问卷模块id更新问卷模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "要修改的问卷模块id", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "body", name = "moduleForm", value = "问卷模块实体", required = true, dataType = "ModuleForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody ModuleForm moduleForm) {
        Module module = moduleForm.toPo(Module.class);
        module.setId(id);
        moduleServiceImpl.updateById(module);
        return Result.success();
    }

    /**
     * @param id 要删除的问卷模块id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个问卷模块
     */
    @ApiOperation(value = "删除一个问卷模块", notes = "根据id来删除一个问卷模块")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要删除的问卷模块id", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        moduleServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param ids 问卷模块的id列表
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:57
     * @description 批量删除问卷模块
     */
    @ApiOperation(value = "批量删除问卷模块", notes = "根据多个id批量删除问卷模块")
    @ApiImplicitParam(paramType = "body", name = "ids", value = "要删除的问卷模块id们", required = true, dataType = "string")
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        moduleServiceImpl.removeByIds(ids);
        return Result.success();
    }
}
