package com.m3ds.que.center.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.common.web.entity.po.BasePo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Map;

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
@Accessors(chain = true)
@FieldNameConstants
@TableName(value = "question", autoResultMap = true)
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
     * 问题类型(0问题，1诊断框问题，2诊断框子问题)
     */
    private Integer queType;


    /**
     * 选项类型(TEXT,INPUT,RADIO,CHECKBOX)
     */
    private String optType;


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
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> optData;

    /**
     * 跳转规则
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> skipRuleIds;

    /**
     * 选择规则
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> refIds;

    /**
     * 序号
     */
    private Long serialNum;

    @TableLogic
    private Boolean deleted;

}
