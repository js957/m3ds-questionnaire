package com.m3ds.que.center.entity.form;


import com.m3ds.que.center.entity.param.TemplateQueryParam;
import com.m3ds.que.common.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * tangzheng
 * 问卷模板QueryForm类
 */
@ApiModel
@Data
public class TemplateQueryForm extends BaseQueryForm<TemplateQueryParam> {

    /**
     * 模板名
     */
    @ApiModelProperty(value = "模板名")
    private String templateName;


}
