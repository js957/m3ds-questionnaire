package com.m3ds.que.account.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m3ds.que.account.entity.po.Subject;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * tangzheng
 * 受试者Form类
 */
@ApiModel
@Data
public class SubjectForm extends BaseForm<Subject> {

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
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;

    /**
     * 检查日期
     */
    @ApiModelProperty(value = "检查日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate begindate;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）
     */
    @ApiModelProperty(value = "问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）")
    private Integer state;

    /**
     * 诊断的疾病集合
     */
    @ApiModelProperty(value = "诊断的疾病集合")
    private String result;



}
