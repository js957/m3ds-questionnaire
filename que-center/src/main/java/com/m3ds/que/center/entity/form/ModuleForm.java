package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.common.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * tangzheng
 * 问卷模块Form类
 */
@ApiModel
@Data
public class ModuleForm extends BaseForm<Module> {

    /**
     * 所属问卷模板
     */
    @NotBlank(message = "数据异常:无模板信息")
    @ApiModelProperty(value = "所属问卷模板id")
    private String templateId;

    /**
     * 模块名
     */
    @NotBlank(message = "模块名称为空")
    @ApiModelProperty(value = "模块名")
    private String moduleName;

    /**
     * 模块编号
     */
    @NotBlank(message = "模块编号为空")
    @ApiModelProperty(value = "模块编号")
    private String moduleNo;

    /**
     * 模块说明
     */
    @ApiModelProperty(value = "模块说明")
    private String description;

    /**
     * 判断模块中的题目是否加入顺序队列
     */
    @ApiModelProperty(value = "判断模块中的题目是否加入顺序队列")
    private Boolean sorted;


}
