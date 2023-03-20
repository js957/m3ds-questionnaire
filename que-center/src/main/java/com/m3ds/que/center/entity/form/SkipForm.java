package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.common.web.entity.form.BaseForm;
import com.m3ds.que.common.web.validator.group.AddGroup;
import com.m3ds.que.common.web.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

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
     * 跳转至题目为0	跳转至诊断框为1	跳转至子问题为2	跳转至模块为3	跳转至诊断程序问题4
     */
    @NotNull(message = "类型不许为空", groups = {AddGroup.class})
    private Integer type;

    /**
     * 根据问题id获取子问题
     */
    @NotNull(message = "绑定的问题id不允许为空", groups = {AddGroup.class})
    private String queId;

    /**
     * 跳转目标id
     */
    @NotNull(message = "跳转目标不允许为空")
    private String target;

    /**
     * 跳转条件
     */
    @NotNull(message = "跳转条件不允许为空", groups = {AddGroup.class, UpdateGroup.class})
    private Map<String, Object> conditionJson;
}
