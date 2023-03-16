package com.m3ds.que.api.web.controller;


import com.m3ds.que.center.entity.form.SkipForm;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.center.service.IQuestionService;
import com.m3ds.que.center.service.ISkipService;
import com.m3ds.que.common.core.vo.Result;
import com.m3ds.que.common.web.validator.ValidatorUtils;
import com.m3ds.que.common.web.validator.group.AddGroup;
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
@RequestMapping("/skip")
public class SkipController {

    @Autowired
    private ISkipService skipServiceImpl;

    @Autowired
    private IQuestionService questionServiceImpl;
    /**
    *@Param:
    *@Author: wjs
    *@date: 20:28
     * 创建跳转规则
    */
    @PostMapping("/create")
    public Result create(@RequestBody SkipForm skipForm){
        ValidatorUtils.validateEntity(skipForm, AddGroup.class);
        Skip skip = skipForm.toPo(Skip.class);
        skip.setType(questionServiceImpl.getById(skipForm.getTarget()).getQueType());
        boolean save = skipServiceImpl.saveOrUpdate(skip);
        if(save){
            Question question = new Question();
            question.setId(skipForm.getQueId());
            question.setSkipRuleId(skip.getId());
            save = questionServiceImpl.updateById(question);
        }
        return Result.success(save);
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 20:36
     * 删除跳转规则(算了不让删)
    */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){

        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 21:00
     * 修改跳转规则
    */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @RequestBody SkipForm skipForm){
        return Result.success(skipServiceImpl.updateById(skipForm.toPo(Skip.class)));
    }


}
