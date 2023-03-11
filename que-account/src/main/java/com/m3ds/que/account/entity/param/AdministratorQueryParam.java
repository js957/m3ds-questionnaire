package com.m3ds.que.account.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.common.web.entity.param.BaseParam;
import lombok.Data;

/**
 * tangzheng
 * 管理员Param类
 */
@Data
public class AdministratorQueryParam extends BaseParam<Administrator> {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 性别
     */
    private Integer gender;

    @Override
    public QueryWrapper<Administrator> build() {
        QueryWrapper<Administrator> queryWrapper = super.build();
        queryWrapper.like(this.userName != null, "user_name", this.userName);
        queryWrapper.like(this.name != null, "name", this.name);
        queryWrapper.eq(this.phone != null, "phone", this.phone);
        queryWrapper.eq(this.email != null, "email", this.email);
        queryWrapper.eq(this.gender != null, "gender", this.gender);
        return queryWrapper;
    }

}
