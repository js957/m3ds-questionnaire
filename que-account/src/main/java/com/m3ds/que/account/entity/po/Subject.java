package com.m3ds.que.account.entity.po;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Subject extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 受试者姓名
     */
    private String name;

    /**
     * 受试者电话
     */
    private String phone;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 负责的管理员id
     */
    private String adminId;

    /**
     * 检查日期
     */
    private LocalDate begindate;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）
     */
    private Integer state;

    /**
     * 诊断的疾病集合
     */
    private String result;


}
