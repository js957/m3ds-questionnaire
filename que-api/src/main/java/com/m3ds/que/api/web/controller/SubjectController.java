package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.account.entity.form.SubjectForm;
import com.m3ds.que.account.entity.form.SubjectQueryForm;
import com.m3ds.que.account.entity.param.SubjectQueryParam;
import com.m3ds.que.account.entity.po.Subject;
import com.m3ds.que.account.entity.vo.SubjectVo;
import com.m3ds.que.account.service.ISubjectService;
import com.m3ds.que.api.annotation.Login;
import com.m3ds.que.center.entity.po.SubjectQue;
import com.m3ds.que.center.service.ISubjectQueService;
import com.m3ds.que.center.service.ITemplateService;
import com.m3ds.que.common.core.vo.Result;
import com.m3ds.que.common.web.validator.ValidatorUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 受试者controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@Validated
@RequestMapping("/psyquestioner/subject")
public class SubjectController {
    @Resource
    private ISubjectService subjectServiceImpl;

    @Resource
    private ISubjectQueService subjectQueServiceImpl;

    @Resource
    private ITemplateService templateServiceImpl;

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
    @Login
    public Result get(@PathVariable String id) {
        Subject subject = subjectServiceImpl.getById(id);
        if (subject == null) {
            return Result.fail("没有找到该受试者！");
        }
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
    @Login
    public Result conditions(@RequestBody @Valid SubjectQueryForm subjectQueryForm) {
        QueryWrapper<Subject> queryWrapper = subjectQueryForm.toParam(SubjectQueryParam.class).build();
        Page page = subjectServiceImpl.page(subjectQueryForm.getPage(), queryWrapper);
        return Result.success(page.setRecords((List) page.getRecords().stream().map(t -> new SubjectVo((Subject) t)).collect(Collectors.toList())));
    }


    @ApiOperation(value = "根据管理员查询受试者", notes = "根据管理员查询受试者")
    @ApiImplicitParam(paramType = "path", name = "id", value = "受试者id", required = true, dataType = "string")
    @GetMapping("/admin")
    @Login
    public Result byAdmin(HttpServletRequest request) {
        String adminId = String.valueOf(request.getAttribute("userId"));
        return Result.success(subjectServiceImpl
                .list(new QueryWrapper<Subject>()
                        .eq("admin_id", adminId))
                .stream().map(SubjectVo::new)
                .collect(Collectors.toList()));
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
    @Login
    public Result query(SubjectQueryParam subjectQueryParam) {
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
    @Login
    public Result save(@RequestBody @Valid SubjectForm subjectForm, @RequestAttribute String userId, HttpServletRequest request) {
        if(StringUtils.isEmpty(userId)){
            userId = String.valueOf(request.getAttribute("userId"));
        }
        Subject subject = subjectForm.toPo(Subject.class);
        subject.setAdminId(userId);
        subjectServiceImpl.save(subject);

        // 0: 未完成
        subjectQueServiceImpl.saveBatch(
                templateServiceImpl
                        .list()
                        .stream()
                        .map(template -> {return new SubjectQue(subject.getId(), template.getId(), 0);})
                        .collect(Collectors.toList()));
        return Result.success();
    }

    /**
     * @param subjectForms 要保存的受试者对象们
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 批量保存受试者
     */
    @ApiOperation(value = "批量保存受试者", notes = "批量保存受试者")
    @ApiImplicitParam(paramType = "body", name = "subjectForms", value = "受试者的实体", required = true, dataType = "List<SubjectForm>")
    @PostMapping("/saveBatch")
    @Login
    public Result saveBatch(@RequestBody List<SubjectForm> subjectForms, @RequestAttribute String userId, HttpServletRequest request) {
        if(StringUtils.isEmpty(userId)){
            userId = String.valueOf(request.getAttribute("userId"));
        }
        List<Subject> subjects = new ArrayList<>();
        String finalUserId = userId;
        subjectForms.forEach(s ->{
            ValidatorUtils.validateEntity(s);
            Subject subject = s.toPo(Subject.class);
            subject.setAdminId(finalUserId);
            subjects.add(subject);
        });
        subjectServiceImpl.saveBatch(subjects);

        subjects.forEach(subject -> {
            subjectQueServiceImpl.saveBatch(
                templateServiceImpl
                        .list()
                        .stream()
                        .map(template -> {return new SubjectQue(subject.getId(), template.getId(), 0);})
                        .collect(Collectors.toList()));
        });

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
    @Login
    public Result update(@PathVariable String id, @RequestBody SubjectForm subjectForm, @RequestAttribute String userId) {
        Subject subject = subjectForm.toPo(Subject.class);
        subject.setId(id);
        subject.setAdminId(userId);
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
    @Login
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
    @DeleteMapping("/del/batch")
    @Login
    public Result deleteBatch(@RequestBody List<String> ids) {
        subjectServiceImpl.removeByIds(ids);
        return Result.success();
    }
}
