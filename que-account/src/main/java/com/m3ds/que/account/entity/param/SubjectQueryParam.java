package com.m3ds.que.account.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.account.entity.po.Subject;
import com.m3ds.que.common.web.entity.param.BaseParam;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 * tangzheng
 * 受试者Param类
 */
@Data
public class SubjectQueryParam extends BaseParam<Subject> {

    /**
     * 受试者姓名
     */
    private String name;

    /**
     * 受试者电话
     */
    private String phone;

    /**
     * 检查日期
     */
    private LocalDate begindate;

    /**
     * 问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）
     */
    private Integer state;

    @Override
    public QueryWrapper<Subject> build() {
        QueryWrapper<Subject> queryWrapper = super.build();
        queryWrapper.like(!StringUtils.isEmpty(this.name), "name", this.name);
        queryWrapper.eq(!StringUtils.isEmpty(this.phone), "phone", this.phone);
        queryWrapper.eq(this.begindate != null, "begindate", this.begindate);
        queryWrapper.eq(this.state != null, "state", this.state);
        return queryWrapper;
    }

}
