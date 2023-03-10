package com.m3ds.que.center.entity.vo;

import com.m3ds.que.center.entity.po.Answer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * tangzheng
 * 问卷结果Vo类
 */
@Data
@NoArgsConstructor
public class AnswerVo {

    public AnswerVo(Answer answer){
        BeanUtils.copyProperties(answer, this);
    }

    /**
     * 受试者id
     */
    private String subId;

    /**
     * 问题id
     */
    private String queId;

    /**
     * 问题提交答案0，	诊断框提交答案1，	问题子问题提交答案2，	诊断框子问题提交答案3
     */
    private Integer type;

    /**
     * 提交结果代表的含义
     */
    private String description;

    /**
     * 选项结果(默认0为否，是为1，分数为分数,输入为输入数)
     */
    private String result;


}
