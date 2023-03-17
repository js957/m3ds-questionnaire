package com.m3ds.que.account.entity.form;

import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author tangzheng
 * @date 2023/3/17 19:31
 * @description 验证登录信息
 */
@Data
public class AdministratorLoginForm extends BaseForm<Administrator> {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码为空")
    private String password;

}
