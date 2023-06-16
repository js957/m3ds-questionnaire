package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.common.web.entity.form.BaseForm;
import com.m3ds.que.common.web.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * tangzheng
 * 问卷结果Form类
 */
@ApiModel
@Data
public class AnswerForm extends BaseForm<Answer> {

    @NotBlank(message = "数据异常:无id信息", groups = UpdateGroup.class)
    @ApiModelProperty(value = "模块答案id")
    private String id;
    /**
     * 受试者id
     */
    @NotBlank(message = "数据异常:无受试者信息")
    @ApiModelProperty(value = "受试者id")
    private String subId;

    /**
     * 受试者问卷id
     */
    @NotBlank(message = "数据异常:无受试者问卷信息")
    @ApiModelProperty(value = "受试者问卷id")
    private String subQueId;

    /**
     * 模块id
     */
    @NotBlank(message = "数据异常:无模块信息")
    @ApiModelProperty(value = "模块id")
    private String moduleId;

    /**
     * 模块编号，如A
     */
    @NotBlank(message = "数据异常:模块信息不完整")
    @ApiModelProperty(value = "模块编号")
    private String moduleNo;

    /**
     * 结果集合，示例{'1001':{'label':'是','value':1,'type':0},'1002':...}
     */
    @ApiModelProperty(value = "该模块的回答结果")
    private Map<String, Object> queResult;

    /**
     * 当前量表的状态状态(0未完成，1进行中，2已完成未提交，3 已完成已提交)
     */
    @ApiModelProperty(value = "该模块的回答结果")
    private Integer state;

}
