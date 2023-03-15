package com.m3ds.que.account.entity.po;

import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * tangzheng
 * 管理员实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Administrator extends BasePo<Administrator> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 头像地址
     */
    private String profile;

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

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 个人简介
     */
    private String description;


}
