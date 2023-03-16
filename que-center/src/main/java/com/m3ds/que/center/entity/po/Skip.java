package com.m3ds.que.center.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.m3ds.que.center.entity.struct.ConditionStruct;
import com.m3ds.que.common.web.entity.po.BasePo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

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
@FieldNameConstants
public class Skip extends BasePo<Skip> {

    private static final long serialVersionUID = 1L;

    /**
     * 诊断程序描述
     */
    private String description;

    /**
     * 跳转至题目为0	跳转至诊断框为1	跳转至子问题为2	跳转至模块为3	跳转至诊断程序问题4	
     */
    private Integer type;

    /**
     * 根据问题id获取子问题
     */
    private String queId;

    /**
     * 跳转目标id
     */
    private String target;

    /**
     * 跳转条件
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private ConditionStruct conditionJson;


}
