package com.m3ds.que.center.entity.vo;

import com.m3ds.que.center.entity.po.Answer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * tangzheng
 * 问卷结果Vo类
 */
@Data
@NoArgsConstructor
public class AnswerVo {

    public AnswerVo(Answer answer) {
        BeanUtils.copyProperties(answer, this);
    }

    /**
     * 受试者id
     */
    private String subId;

    /**
     * 诊断模块id
     */
    private String moduleId;

    /**
     * 模块编号，如A
     */
    private String moduleNo;

    /**
     * 结果集合，示例{'1001':{'label':'是','value':1,'type':0},'1002':...}
     */
    private Map<String, Object> queResult;

}
