package com.m3ds.que.account.entity.vo;

import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.common.web.entity.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * tangzheng
 * 管理员Vo类
 */
@Data
@NoArgsConstructor
public class AdministratorVo extends BaseVo<Administrator> {

    public AdministratorVo(Administrator administrator) {
        BeanUtils.copyProperties(administrator, this);
    }

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
     * 头像地址
     */
    private String profile;

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
