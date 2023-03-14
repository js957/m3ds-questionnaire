package com.m3ds.que.account.entity.form;

import com.m3ds.que.account.entity.po.Subject;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @NotBlank(message = "受试者姓名为空")
    @ApiModelProperty(value = "受试者姓名")
    private String name;

    /**
     * 受试者电话
     */
    @NotBlank(message = "受试者电话为空")
    @ApiModelProperty(value = "受试者电话")
    private String phone;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    /**
     * 负责的管理员id
     */
    @NotBlank(message = "管理员信息出错")
    @ApiModelProperty(value = "负责的管理员id")
    private String adminId;

    /**
     * 检查日期
     */
    @ApiModelProperty(value = "检查日期")
    private LocalDate begindate;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
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
