package com.m3ds.que.center.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.common.web.entity.po.BasePo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

import java.util.Map;

/**
 * tangzheng
 * 回答结果实体类，存储一整个模块的结果
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "answer", autoResultMap = true)
@FieldNameConstants
public class Answer extends BasePo<Answer> {

    private static final long serialVersionUID = 1L;

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
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> queResult;

}
