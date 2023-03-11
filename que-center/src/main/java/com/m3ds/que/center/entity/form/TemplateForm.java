package com.m3ds.que.center.entity.form;


import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * tangzheng
 * 问卷模板Form类
 */
@ApiModel
@Data
public class TemplateForm extends BaseForm<Template> {

    /**
     * 模板名
     */
    @NotBlank(message = "模板名为空")
    @ApiModelProperty(value = "模板名")
    private String templateName;

    /**
     * 模板介绍
     */
    @ApiModelProperty(value = "模板介绍")
    private String description;


}
