package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * tangzheng
 * 问卷结果Form类
 */
@ApiModel
@Data
public class AnswerForm extends BaseForm<Answer> {

    /**
     * 受试者id
     */
    @NotBlank(message = "数据异常:无受试者信息")
    @ApiModelProperty(value = "受试者id")
    private String subId;

    /**
     * 问题id
     */
    @NotBlank(message = "数据异常:无问题信息")
    @ApiModelProperty(value = "问题id")
    private String queId;

    /**
     * 0:问题提交答案，1:诊断框提交答案，2:问题子问题提交答案，3:诊断框子问题提交答案
     */
    @ApiModelProperty(value = "默认0:问题提交答案，1:诊断框提交答案，2:问题子问题提交答案，3:诊断框子问题提交答案")
    private Integer type;

    /**
     * 提交结果代表的含义
     */
    @ApiModelProperty(value = "提交结果代表的含义")
    private String description;

    /**
     * 选项结果(默认0为否，是为1，分数为分数,输入为输入数)
     */
    @NotNull(message = "选项结果不能为空")
    @ApiModelProperty(value = "默认0为否，是为1，分数为分数,输入为输入数")
    private String result;


}
