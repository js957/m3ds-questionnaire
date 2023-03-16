package com.m3ds.que.center.entity.form;

import com.m3ds.que.common.web.entity.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2023/03/15
 */
@Data
public class QuestSortForm {

    @NotNull(message = "请求异常，获取不到模块。")
    private String moduleId;

    @NotNull(message = "请求异常，获取不到问题。")
    private String queId;

    private Long beforePosition;

    private Long afterPosition;
}
