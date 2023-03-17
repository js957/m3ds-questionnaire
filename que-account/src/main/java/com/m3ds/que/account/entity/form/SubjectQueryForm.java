package com.m3ds.que.account.entity.form;

import com.m3ds.que.account.entity.param.SubjectQueryParam;
import com.m3ds.que.common.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * tangzheng
 * 受试者QueryForm类
 */
@ApiModel
@Data
public class SubjectQueryForm extends BaseQueryForm<SubjectQueryParam> {

    /**
     * 受试者姓名
     */
    @ApiModelProperty(value = "受试者姓名")
    private String name;

    /**
     * 受试者电话
     */
    @ApiModelProperty(value = "受试者电话")
    private String phone;

    /**
     * 检查日期
     */
    @ApiModelProperty(value = "检查日期")
    private LocalDate begindate;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String gender;

    /**
     * 问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）
     */
    @ApiModelProperty(value = "问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）")
    private Integer state;


}
