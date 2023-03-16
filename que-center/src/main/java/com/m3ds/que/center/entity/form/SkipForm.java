package com.m3ds.que.center.entity.form;

import com.baomidou.mybatisplus.annotation.TableField;
import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.center.entity.struct.ConditionStruct;
import com.m3ds.que.common.web.entity.form.BaseForm;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import com.m3ds.que.common.web.validator.group.AddGroup;
import com.m3ds.que.common.web.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2023/03/15
 */
@Data
public class SkipForm extends BaseForm<Skip> {

    /**
     * 诊断程序描述
     */
    private String description;


    /**
     * 根据问题id获取子问题
     */
    @NotNull(message = "绑定的问题id不允许为空",groups = {AddGroup.class})
    private String queId;

    /**
     * 跳转目标id
     */
    @NotNull(message = "跳转目标不允许为空")
    private String target;

    /**
     * 跳转条件
     */
    @NotNull(message = "跳转条件不允许为空",groups = {AddGroup.class, UpdateGroup.class})
    private ConditionStruct conditionJson;
}
