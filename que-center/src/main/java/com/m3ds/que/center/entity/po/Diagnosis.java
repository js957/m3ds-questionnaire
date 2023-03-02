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
public class Diagnosis extends BasePo<Diagnosis> {

    private static final long serialVersionUID = 1L;

    /**
     * 诊断框名
     */
    private String illness;

    /**
     * 是否有子问题
     */
    private Boolean subQuestioned;

    /**
     * 诊断框补充说明
     */
    private String description;

    /**
     * 选项
     */
    private String option;

    /**
     * 跳转规则
     */
    private String skipRuleId;

    /**
     * 选择规则
     */
    private String optRuleId;

    /**
     * 插入模块id(在进入诊断框前，插入一个模块，如排除异质性)
     */
    private String insertModuleId;


}
