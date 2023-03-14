package com.m3ds.que.account.entity.vo;

import com.m3ds.que.account.entity.po.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * tangzheng
 * 受试者Vo类
 */
@Data
@NoArgsConstructor
public class SubjectVo {

    public SubjectVo(Subject subject) {
        BeanUtils.copyProperties(subject, this);
    }

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
