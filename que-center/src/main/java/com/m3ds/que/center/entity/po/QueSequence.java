package com.m3ds.que.center.entity.po;

import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueSequence extends BasePo<QueSequence> {

    private static final long serialVersionUID = 1L;

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
