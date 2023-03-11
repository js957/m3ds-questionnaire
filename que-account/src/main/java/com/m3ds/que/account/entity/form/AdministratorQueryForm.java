package com.m3ds.que.account.entity.form;

import com.m3ds.que.account.entity.param.AdministratorQueryParam;
import com.m3ds.que.common.web.entity.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * tangzheng
 * 管理员QueryForm类
 */
@ApiModel
@Data
public class AdministratorQueryForm extends BaseQueryForm<AdministratorQueryParam> {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String name;

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

}
