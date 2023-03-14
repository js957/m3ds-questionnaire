package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.form.AnswerForm;
import com.m3ds.que.center.entity.param.AnswerQueryParam;
import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.center.entity.vo.AnswerVo;
import com.m3ds.que.center.service.IAnswerService;
import com.m3ds.que.common.core.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    public Result save(@Valid @RequestBody AnswerForm answerForm) {
        Answer answer = answerForm.toPo(Answer.class);
        answerServiceImpl.save(answer);
        return Result.success();
    }

}
