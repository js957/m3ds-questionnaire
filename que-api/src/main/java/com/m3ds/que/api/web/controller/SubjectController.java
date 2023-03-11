package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.account.entity.form.SubjectForm;
import com.m3ds.que.account.entity.form.SubjectQueryForm;
import com.m3ds.que.account.entity.param.SubjectQueryParam;
import com.m3ds.que.account.entity.po.Subject;
import com.m3ds.que.account.entity.vo.SubjectVo;
import com.m3ds.que.account.service.ISubjectService;
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
 * 受试者controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/psyquestioner/subject")
public class SubjectController {
    @Resource
    private ISubjectService subjectServiceImpl;

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询受试者
     */
    @ApiOperation(value = "查询受试者", notes = "根据id查找受试者")
    @ApiImplicitParam(paramType = "path", name = "id", value = "受试者id", required = true, dataType = "string")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(new SubjectVo(subjectServiceImpl.getById(id)));
    }

    /**
     * @param subjectQueryForm 受试者查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询参数分页查询受试者
     */
    @ApiOperation(value = "分页查询受试者", notes = "带参数分页查询受试者")
    @ApiImplicitParam(paramType = "body", name = "subjectQueryForm", value = "受试者的实体", required = true, dataType = "SubjectQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody SubjectQueryForm subjectQueryForm) {
        QueryWrapper<Subject> queryWrapper = subjectQueryForm.toParam(SubjectQueryParam.class).build();
        Page page = subjectServiceImpl.page(subjectQueryForm.getPage(), queryWrapper);
        return Result.success(page.setRecords((List) page.getRecords().stream().map(t -> new SubjectVo((Subject) t)).collect(Collectors.toList())));
    }

    /**
     * @param subjectQueryParam 受试者查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询受试者
     */
    @ApiOperation(value = "带查询条件查询受试者", notes = "带查询条件查询受试者")
    @ApiImplicitParam(paramType = "query", name = "subjectQueryParam", value = "受试者的实体", required = true, dataType = "SubjectQueryParam")
    @GetMapping
    public Result query(@RequestParam SubjectQueryParam subjectQueryParam) {
        QueryWrapper<Subject> queryWrapper = subjectQueryParam.build();
        return Result.success((subjectServiceImpl.list(queryWrapper).stream().map(SubjectVo::new)).collect(Collectors.toList()));
    }

    /**
     * @param subjectForm 要保存的受试者对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存受试者
     */
    @ApiOperation(value = "保存受试者", notes = "保存受试者")
    @ApiImplicitParam(paramType = "body", name = "subjectForm", value = "受试者的实体", required = true, dataType = "SubjectForm")
    @PostMapping
    public Result save(@RequestBody SubjectForm subjectForm) {
        Subject subject = subjectForm.toPo(Subject.class);
        subjectServiceImpl.save(subject);
        return Result.success();
    }

    /**
     * @param subjectForm 要更新的受试者对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新受试者
     */
    @ApiOperation(value = "更新受试者", notes = "根据受试者id更新受试者")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "要修改的受试者id", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "body", name = "subjectForm", value = "受试者实体", required = true, dataType = "SubjectForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody SubjectForm subjectForm) {
        Subject subject = subjectForm.toPo(Subject.class);
        subject.setId(id);
        subjectServiceImpl.updateById(subject);
        return Result.success();
    }

    /**
     * @param id 要删除的受试者id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个受试者
     */
    @ApiOperation(value = "删除一个受试者", notes = "根据id来删除一个受试者")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要删除的受试者id", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        subjectServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param ids 受试者的id列表
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:57
     * @description 批量删除受试者
     */
    @ApiOperation(value = "批量删除受试者", notes = "根据多个id批量删除受试者")
    @ApiImplicitParam(paramType = "body", name = "ids", value = "要删除的受试者id们", required = true, dataType = "string")
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        subjectServiceImpl.removeByIds(ids);
        return Result.success();
    }
}
