package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.param.QueSequenceQueryParam;
import com.m3ds.que.common.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * tangzheng
 * 模板问题顺序QueryForm类
 */
@ApiModel
@Data
public class QueSequenceQueryForm extends BaseQueryForm<QueSequenceQueryParam> {

    /**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private String moduleId;

    /**
     * 所属模块编号
     */
    @ApiModelProperty(value = "所属模块编号")
    private String moduleNo;

    /**
     * 问题或诊断框id或诊断程序(跳转)
     */
    @ApiModelProperty(value = "问题或诊断框id或诊断程序(跳转)")
    private String queId;

    /**
     * 0为问题，1为诊断框，2为诊断程序
     */
    @ApiModelProperty(value = "0为问题，1为诊断框，2为诊断程序")
    private Integer type;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer serialNum;


}
