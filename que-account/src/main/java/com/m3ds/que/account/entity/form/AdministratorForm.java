package com.m3ds.que.account.entity.form;

import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * tangzheng
 * 管理员Form类
 */
@ApiModel
@Data
public class AdministratorForm extends BaseForm<Administrator> {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名为空")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码为空")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String name;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String profile;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phone;

    /**
     * 邮箱地址
     */
    @ApiModelProperty(value = "邮箱地址")
    private String email;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 个人简介
     */
    @ApiModelProperty(value = "个人简介")
    private String description;

}
