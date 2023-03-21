package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.m3ds.que.api.annotation.Login;
import com.m3ds.que.center.entity.form.QuestionForm;
import com.m3ds.que.center.entity.form.SkipForm;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.center.entity.vo.QuestionVo;
import com.m3ds.que.center.service.IQuestionService;
import com.m3ds.que.center.service.ISkipService;
import com.m3ds.que.common.core.vo.Result;
import com.m3ds.que.common.web.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * tangzheng
 * 问题controller
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionServiceImpl;

    @Autowired
    private ISkipService skipServiceImpl;

    /**
     * @param questionForm 要保存的对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存问题 有事务
     */
    @PostMapping
    @Login
    @Transactional
    public Result save(@RequestBody @Valid QuestionForm questionForm) {
        //里面的对象要自己拿出来验证,顺便把form类转为po
        Question question = questionForm.toPo(Question.class);
        questionServiceImpl.save(question);
        return Result.success(question.getId());
    }

    /**
     * @param id 要删除的问题id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个问题
     */
    @DeleteMapping(value = "/{id}")
    @Login
    public Result delete(@PathVariable String id) {
        questionServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param questionForm 要更新的问题对象
     * @param id           问题id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新问题
     */
    @PutMapping("/{id}")
    @Login
    public Result update(@PathVariable String id, @RequestBody QuestionForm questionForm) {
        //里面的对象要自己拿出来验证,顺便把form类转为po
        Question question = questionForm.toPo(Question.class);
        question.setId(id);
        questionServiceImpl.updateById(question);
        return Result.success();
    }

    /**
     * @param id 问题表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询问题(包括之下的skip)
     */
    @GetMapping("/{id}")
    @Login
    public Result get(@PathVariable String id) {
        QuestionVo questionVo = questionServiceImpl.queryQuestionWithSkip(id);
        return Result.success(questionVo);
    }

    /**
     * @param moduleId 模块表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据模块id查询问题(包括之下的skip)
     */
    @GetMapping("/queryByModule/{moduleId}")
    @Login
    public Result queryByModule(@PathVariable String moduleId) {
        List<QuestionVo> questionVos = questionServiceImpl.queryByModule(moduleId);
        return Result.success(questionVos);
    }
}
