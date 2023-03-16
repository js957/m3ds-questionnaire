package com.m3ds.que.api.web.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.m3ds.que.center.constant.RedisKeyConstants;
import com.m3ds.que.center.entity.form.QuestSortForm;
import com.m3ds.que.center.entity.form.QuestionForm;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.center.entity.vo.QuestionAppVo;
import com.m3ds.que.center.entity.vo.QuestionVo;
import com.m3ds.que.center.entity.vo.SkipAppVo;
import com.m3ds.que.center.service.IQuestionService;
import com.m3ds.que.center.service.ISkipService;
import com.m3ds.que.center.service.impl.SkipServiceImpl;
import com.m3ds.que.center.utils.SortUtils;
import com.m3ds.que.common.core.vo.Result;
import com.m3ds.que.common.web.validator.ValidatorUtils;
import com.m3ds.que.common.web.validator.group.AddGroup;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private SortUtils sortUtils;

    @Autowired
    private IQuestionService questionServiceImpl;

    @Autowired
    private ISkipService skipServiceImpl;

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 创建问题
    */
    @PostMapping("/create")
    public Result create(@RequestBody QuestionForm questionForm){
        ValidatorUtils.validateEntity(questionForm, AddGroup.class);
        Question question = questionForm.toPo(Question.class);
        question.setSerialNum(sortUtils.getInitialSortPosition(
                StrUtil.format(RedisKeyConstants.MODULE_QUE_POS_DELTA, question.getModuleId())));
        boolean result = questionServiceImpl.saveOrUpdate(question);
        return Result.success(new QuestionAppVo(question));
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 删除问题
    */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        skipServiceImpl.remove(Wrappers.<Skip>lambdaQuery().eq(Skip::getQueId, id));
        return Result.success(questionServiceImpl.removeById(id));
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 修改问题
    */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @RequestBody QuestionForm questionForm){
        Question question = questionForm.toPo(Question.class);
        question.setId(id);
        return Result.success(questionServiceImpl.updateById(question));
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 获取问题
    */
    @GetMapping("/{id}")
    public Result get(@PathVariable String id){
        Question question = questionServiceImpl.getById(id);
        QuestionAppVo questionVo = new QuestionAppVo(question);
        if(StrUtil.isNotEmpty(question.getSkipRuleId())){
            Skip skip = skipServiceImpl.getById(question.getSkipRuleId());
            questionVo.setSkipRule(new SkipAppVo(skip));
        }

        return Result.success(questionVo);
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 21:47
     * 修改顺序
    */
    @PostMapping("/sort")
    public Result sort(@RequestBody QuestSortForm questSortForm){
        ValidatorUtils.validateEntity(questSortForm);
        if (ObjectUtil.isNull(questSortForm.getAfterPosition())
                && ObjectUtil.isNull(questSortForm.getBeforePosition())) {
            return Result.success();
        }
        Question question = questionServiceImpl.getById(questSortForm.getQueId());
        Long sort = sortUtils.calcSortPosition(questSortForm.getBeforePosition(), questSortForm.getAfterPosition());
        question.setSerialNum(sort);
        boolean result = questionServiceImpl.updateById(question);
        QuestionVo questionVo = new QuestionVo(question);
        if(StrUtil.isNotEmpty(question.getSkipRuleId())) {
            questionVo.setSkip(skipServiceImpl.getById(question.getSkipRuleId()));
        }
        return Result.success(questionVo);
    }



}
