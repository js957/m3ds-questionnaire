package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.center.entity.form.QueSequenceForm;
import com.m3ds.que.center.entity.form.QueSequenceQueryForm;
import com.m3ds.que.center.entity.param.QueSequenceQueryParam;
import com.m3ds.que.center.entity.po.QueSequence;
import com.m3ds.que.center.entity.vo.QueSequenceVo;
import com.m3ds.que.center.service.IQueSequenceService;
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
 * 模板问题顺序controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/psyquestioner/que-sequence")
public class QueSequenceController {
    @Resource
    private IQueSequenceService queSequenceServiceImpl;

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询模板问题顺序
     */
    @ApiOperation(value = "查询模板问题顺序", notes = "根据id查找模板问题顺序")
    @ApiImplicitParam(paramType = "path", name = "id", value = "模板问题顺序id", required = true, dataType = "string")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(new QueSequenceVo(queSequenceServiceImpl.getById(id)));
    }

    /**
     * @param queSequenceQueryForm 模板问题顺序查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件分页查询问卷结果
     */
    @ApiOperation(value = "分页模板问题顺序", notes = "带参数分页查询模板问题顺序")
    @ApiImplicitParam(paramType = "body", name = "queSequenceQueryForm", value = "模板问题顺序的实体", required = true, dataType = "QueSequenceQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody QueSequenceQueryForm queSequenceQueryForm) {
        QueryWrapper<QueSequence> queryWrapper = queSequenceQueryForm.toParam(QueSequenceQueryParam.class).build();
        Page page = queSequenceServiceImpl.page(queSequenceQueryForm.getPage(), queryWrapper);
        return Result.success(page.setRecords((List) page.getRecords().stream().map(t -> new QueSequenceVo((QueSequence) t)).collect(Collectors.toList())));
    }

    /**
     * @param queSequenceQueryParam 模板问题顺序查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询问卷结果
     */
    @ApiOperation(value = "带查询条件查询问卷结果", notes = "带查询条件查询问卷结果")
    @ApiImplicitParam(paramType = "query", name = "queSequenceQueryParam", value = "模板问题顺序的实体", required = true, dataType = "QueSequenceQueryParam")
    @GetMapping
    public Result query(@RequestParam QueSequenceQueryParam queSequenceQueryParam) {
        QueryWrapper<QueSequence> queryWrapper = queSequenceQueryParam.build();
        return Result.success((queSequenceServiceImpl.list(queryWrapper).stream().map(QueSequenceVo::new)).collect(Collectors.toList()));
    }

    /**
     * @param queSequenceForm 要保存的模板问题顺序对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存模板问题顺序
     */
    @ApiOperation(value = "保存模板问题顺序", notes = "保存模板问题顺序")
    @ApiImplicitParam(paramType = "body", name = "queSequenceForm", value = "模板问题顺序的实体", required = true, dataType = "QueSequenceForm")
    @PostMapping
    public Result save(@RequestBody QueSequenceForm queSequenceForm) {
        QueSequence queSequence = queSequenceForm.toPo(QueSequence.class);
        queSequenceServiceImpl.save(queSequence);
        return Result.success();
    }

    /**
     * @param queSequenceForm 要更新的模板问题顺序对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新模板问题顺序
     */
    @ApiOperation(value = "更新模板问题顺序", notes = "根据模板问题顺序id更新模板问题顺序")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "要修改的模板问题顺序id", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "body", name = "queSequenceForm", value = "模板问题顺序实体", required = true, dataType = "QueSequenceForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody QueSequenceForm queSequenceForm) {
        QueSequence queSequence = queSequenceForm.toPo(QueSequence.class);
        queSequence.setId(id);
        queSequenceServiceImpl.updateById(queSequence);
        return Result.success();
    }

    /**
     * @param id 要删除的模板问题顺序id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个模板问题顺序
     */
    @ApiOperation(value = "删除一个模板问题顺序", notes = "根据id来删除一个模板问题顺序")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要删除的模板问题顺序id", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        queSequenceServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param ids 模板问题顺序的id列表
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:57
     * @description 批量删除模板问题顺序
     */
    @ApiOperation(value = "批量删除模板问题顺序", notes = "根据多个id批量删除模板问题顺序")
    @ApiImplicitParam(paramType = "body", name = "ids", value = "要删除的模板问题顺序id们", required = true, dataType = "string")
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        queSequenceServiceImpl.removeByIds(ids);
        return Result.success();
    }
}
