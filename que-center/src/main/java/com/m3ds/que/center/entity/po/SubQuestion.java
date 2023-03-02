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
public class SubQuestion extends BasePo<SubQuestion> {

    private static final long serialVersionUID = 1L;

    /**
     * 根据问题id获取子问题
     */
    private String queId;

    /**
     * 题目子问题为0,诊断框子问题为1
     */
    private Integer type;

    /**
     * 子问题编号
     */
    private String subQueNo;

    /**
     * 是否有子问题
     */
    private Boolean subQuestioned;

    /**
     * 问题
     */
    private String issue;

    /**
     * 问题补充
     */
    private String note;

    /**
     * 提醒改题目由谁作答
     */
    private Integer answers;

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


}
