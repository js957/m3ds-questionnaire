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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * tangzheng
 * 跳转controller
 */
@RestController
@RequestMapping("/skip")
public class SkipController {

    @Autowired
    private IQuestionService questionServiceImpl;

    @Autowired
    private ISkipService skipServiceImpl;

    /**
     * @param skipRules 要保存的对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存跳转规则 有事务
     */
    @PostMapping("/saveBatch/{queId}")
    @Login
    @Transactional
    public Result saveBatch(@RequestBody @Valid List<SkipForm> skipRules, @PathVariable String queId) {
        if (skipRules == null){
            skipRules = new ArrayList<>();
        }
        if (StringUtils.isEmpty(queId)){
            return Result.fail("系统错误：没有找到该问题");
        }
        DefaultIdentifierGenerator generator = new DefaultIdentifierGenerator();
        List<Skip> skips = new ArrayList<>();
        List<String> skipIds = new ArrayList<>();
        for (SkipForm skipRule : skipRules) {
            ValidatorUtils.validateEntity(skipRule);
            Skip skip = skipRule.toPo(Skip.class);
            String skipId = String.valueOf(generator.nextId(skip));
            skip.setQueId(queId);
            skip.setId(skipId);
            skipIds.add(skipId);
            skips.add(skip);
        }
        //里面的对象要自己拿出来验证,顺便把form类转为po
        Question question = new Question();
        question.setId(queId);
        question.setSkipRuleIds(skipIds);
        questionServiceImpl.updateById(question);
        QueryWrapper<Skip> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("que_id", queId);
        //如果又要更新又要插入，会很乱，没必要
        skipServiceImpl.remove(queryWrapper);
        skipServiceImpl.saveBatch(skips);
        return Result.success();
    }
}
