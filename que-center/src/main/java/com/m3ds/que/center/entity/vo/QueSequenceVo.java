package com.m3ds.que.center.entity.vo;

import com.m3ds.que.center.entity.po.QueSequence;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * tangzheng
 * 模板问题顺序Vo类
 */
@Data
@NoArgsConstructor
public class QueSequenceVo {

    public QueSequenceVo(QueSequence queSequence){
        BeanUtils.copyProperties(queSequence, this);
    }

    /**
     * 模块id
     */
    private String moduleId;

    /**
     * 所属模块编号
     */
    private String moduleNo;

    /**
     * 问题或诊断框id或诊断程序(跳转)
     */
    private String queId;

    /**
     * 0为问题，1为诊断框，2为诊断程序
     */
    private Integer type;

    /**
     * 序号
     */
    private Integer serialNum;


}
