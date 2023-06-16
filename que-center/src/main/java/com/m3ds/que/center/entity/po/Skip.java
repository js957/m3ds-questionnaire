package com.m3ds.que.center.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.m3ds.que.common.web.entity.po.BasePo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@FieldNameConstants
public class Skip extends BasePo<Skip> {

    private static final long serialVersionUID = 1L;

    /**
     * 诊断程序描述
     */
    private String description;

    /**
     * 1：按各题选项跳转，2：按答题分数跳转，3：按选中数量跳转
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
     * 排序序号
     */
    private Long serialNum;

    /**
     * 跳转条件
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> conditionJson;

    @TableLogic
    private Boolean deleted;

}
