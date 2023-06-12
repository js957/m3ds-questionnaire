package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.api.annotation.Login;
import com.m3ds.que.center.constant.WebConstants;
import com.m3ds.que.center.entity.form.AnswerForm;
import com.m3ds.que.center.entity.param.AnswerQueryParam;
import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.po.SubjectQue;
import com.m3ds.que.center.entity.vo.AnswerVo;
import com.m3ds.que.center.service.IAnswerService;
import com.m3ds.que.center.service.IModuleService;
import com.m3ds.que.center.service.ISubjectQueService;
import com.m3ds.que.center.service.impl.ModuleServiceImpl;
import com.m3ds.que.common.core.vo.Result;
import com.m3ds.que.common.web.validator.ValidatorUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 回答结果controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/psyquestioner/answer")
public class AnswerController {

    @Resource
    private IAnswerService answerServiceImpl;

    @Resource
    private ISubjectQueService subjectQueServiceImpl;

    @Resource
    private IModuleService moduleServiceImpl;


    /**
     * @param answerQueryParam 回答结果查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询问卷结果
     */
    @ApiOperation(value = "带查询条件查询回答结果", notes = "带查询条件查询回答结果")
    @ApiImplicitParam(paramType = "query", name = "answerQueryParam", value = "回答结果的实体", required = true, dataType = "AnswerQueryParam")
    @GetMapping
    @Login
    public Result query(@Valid AnswerQueryParam answerQueryParam) {
        QueryWrapper<Answer> queryWrapper = answerQueryParam.build();
        return Result.success((answerServiceImpl.list(queryWrapper).stream().map(AnswerVo::new)).collect(Collectors.toList()));
    }

    /**
     * @param answerForm 要保存的回答结果对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存回答结果
     */
    @ApiOperation(value = "保存回答结果", notes = "保存回答结果")
    @ApiImplicitParam(paramType = "body", name = "answerForm", value = "回答结果的实体", required = true, dataType = "AnswerForm")
    @PostMapping
    @Login
    public Result save(@RequestBody @Valid AnswerForm answerForm) {
        // 验证
        ValidatorUtils.validateEntity(answerForm);
        // 查询是否已有回答
        Answer answer = answerForm.toPo(Answer.class);
        Answer findInData = answerServiceImpl.getOne(new QueryWrapper<Answer>()
                .eq("sub_id", answer.getSubId())
                .eq("module_id", answer.getModuleId())
                .last("LIMIT 1"));
        if (findInData == null) {
            // 没有就添加
            answerServiceImpl.save(answer);
        } else {
            // 有就更新
            answer.setId(findInData.getId());
            answerServiceImpl.updateById(answer);
        }
        Module module = moduleServiceImpl.getById(answer.getModuleId());
        SubjectQue subjectQue = subjectQueServiceImpl.getOne(new QueryWrapper<SubjectQue>()
                .eq("subject_id", answer.getSubId())
                .eq("template_id", module.getTemplateId())
                .last("limit 1"));
        // 1: 进行中
        subjectQue.setState(WebConstants.subjectQueState.InProgress.getIndex());
        subjectQueServiceImpl.updateById(subjectQue);

        return Result.success();
    }

    /**
     * @param answerForms 要保存的回答结果对象们
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 批量保存回答结果(就是提交)
     */
    @ApiOperation(value = "批量保存回答结果", notes = "批量保存回答结果")
    @PostMapping("/saveBatch")
    @Login
    public Result save(@RequestBody @Valid List<AnswerForm> answerForms) {
        List<Answer> answers = new ArrayList<>();
        for (AnswerForm answerForm : answerForms) {
            ValidatorUtils.validateEntity(answerForm);
            answers.add(answerForm.toPo(Answer.class));
        }
        answerServiceImpl.saveBatch(answers);

        String templateId = moduleServiceImpl.getById(answers.get(0).getModuleId()).getTemplateId();
        String subId = answers.get(0).getSubId();

        SubjectQue subjectQue = subjectQueServiceImpl.getOne(new QueryWrapper<SubjectQue>()
                .eq("subject_id", subId)
                .eq("template_id", templateId)
                .last("limit 1"));
        // 2: 已完成
        subjectQue.setState(WebConstants.subjectQueState.Completed.getIndex());
        subjectQueServiceImpl.updateById(subjectQue);

        return Result.success();
    }

    /**
     * @param subjectId  要保存的回答结果对象们
     * @param templateId 要保存的回答结果对象们
     *                   根据受试者和模板查询问卷完整记录
     */
    @GetMapping("/answerHistory")
    @Login
    public Result answerHistory(String subjectId, String templateId) {
        if (StringUtils.isEmpty(subjectId) || StringUtils.isEmpty(templateId)) {
            return Result.fail("参数不完整");
        }
        List<Map<String, Object>> resultList = answerServiceImpl.answerHistory(subjectId, templateId);
        return Result.success(resultList);
    }

}
