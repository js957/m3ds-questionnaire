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
public class Question extends BasePo<Question> {

    private static final long serialVersionUID = 1L;

    /**
     * 问题属于哪个模块
     */
    private String moduleId;

    /**
     * 模块编号用于显示
     */
    private String moduleNo;

    /**
     * 问题的编号用于线索
     */
    private String questionNo;

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
