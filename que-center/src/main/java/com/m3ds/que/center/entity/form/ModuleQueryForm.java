package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.param.ModuleQueryParam;
import com.m3ds.que.common.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * tangzheng
 * 问卷结果QueryForm类
 */
@ApiModel
@Data
public class ModuleQueryForm extends BaseQueryForm<ModuleQueryParam> {

    /**
     * 所属问卷模板
     */
    @ApiModelProperty(value = "所属问卷模板id")
    private String templateId;

    /**
     * 模块名
     */
    @ApiModelProperty(value = "模块名")
    private String moduleName;

    /**
     * 模块编号
     */
    @ApiModelProperty(value = "模块编号")
    private String moduleNo;

    /**
     * 判断模块中的题目是否加入顺序队列
     */
    @ApiModelProperty(value = "判断模块中的题目是否加入顺序队列")
    private Boolean sorted;


}
