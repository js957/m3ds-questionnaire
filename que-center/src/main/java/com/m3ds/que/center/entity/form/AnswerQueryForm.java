package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.param.AnswerQueryParam;
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
public class AnswerQueryForm extends BaseQueryForm<AnswerQueryParam> {

    /**
     * 受试者id
     */
    @ApiModelProperty(value = "受试者id")
    private String subId;

    /**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private String moduleId;

}
