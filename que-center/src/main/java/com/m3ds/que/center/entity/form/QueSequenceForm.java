package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.QueSequence;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * tangzheng
 * 模板问题顺序Form类
 */
@ApiModel
@Data
public class QueSequenceForm extends BaseForm<QueSequence> {

    /**
     * 模块id
     */
    @NotBlank(message = "数据异常:无模块信息")
    @ApiModelProperty(value = "模块id")
    private String moduleId;

    /**
     * 所属模块编号
     */
    @NotBlank(message = "数据异常:无模块编号信息")
    @ApiModelProperty(value = "所属模块编号")
    private String moduleNo;

    /**
     * 问题或诊断框id或诊断程序(跳转)
     */
    @NotBlank(message = "数据异常:无问题信息")
    @ApiModelProperty(value = "问题或诊断框id或诊断程序(跳转)")
    private String queId;

    /**
     * 0为问题，1为诊断框，2为诊断程序
     */
    @NotBlank(message = "类别不能为空")
    @ApiModelProperty(value = "0为问题，1为诊断框，2为诊断程序")
    private Integer type;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer serialNum;


}
