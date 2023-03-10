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
     * 问题id
     */
    @ApiModelProperty(value = "问题id")
    private String queId;

    /**
     * 问题提交答案0，	诊断框提交答案1，	问题子问题提交答案2，	诊断框子问题提交答案3
     */
    @ApiModelProperty(value = "默认0:问题提交答案，1:诊断框提交答案，2:问题子问题提交答案，3:诊断框子问题提交答案")
    private Integer type;



}
