package com.m3ds.que.center.entity.param;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.common.web.entity.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * tangzheng
 * 问卷模板Param类
 */
@ApiModel
@Data
public class TemplateQueryParam extends BaseParam<Template> {

    /**
     * 模板名
     */
    @ApiModelProperty(value = "模板名")
    private String templateName;


    @Override
    public QueryWrapper<Template> build() {
        QueryWrapper<Template> queryWrapper = super.build();
        queryWrapper.like(this.templateName != null, "template_name", this.templateName);
        return queryWrapper;
    }

}
