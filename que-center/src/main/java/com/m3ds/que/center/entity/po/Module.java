package com.m3ds.que.center.entity.po;

import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * tangzheng
 * 问款模块实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Module extends BasePo<Module> {

    private static final long serialVersionUID = 1L;

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
     * 判断模块是否加入顺序队列
     */
    private Boolean sorted;


    /**
     * 排序序号
     */
    private Integer serialNum;
}
