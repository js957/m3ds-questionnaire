package com.m3ds.que.center.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by wjs on 2023/06/13
 */
@ApiModel
@Data
public class ModuleTemplateForm {

    /**
     * 所属问卷模板
     */
    @NotBlank(message = "数据异常:无模板信息")
    @ApiModelProperty(value = "所属问卷模板id")
    private String templateId;

    /**
     * 所属问卷模板
     */
    @NotBlank(message = "数据异常:无模块信息")
    @ApiModelProperty(value = "所属问卷模块id")
    private String moduleId;
}
