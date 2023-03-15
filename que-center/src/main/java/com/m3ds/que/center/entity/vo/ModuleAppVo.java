package com.m3ds.que.center.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * tangzheng
 * 问卷模快在App上的Vo类
 */
@Data
@NoArgsConstructor
@TableName(value = "module", autoResultMap = true)
public class ModuleAppVo {

    /**
     * 模板id
     */
    private String id;

    /**
     * 所属问卷模板
     */
    private String templateId;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 模块编号
     */
    private String moduleNo;

    /**
     * 模块说明
     */
    private String description;

    /**
     * 模块下的问题列表
     */
    private List<QuestionAppVo> questions;
}
