package com.m3ds.que.center.entity.form;

import com.m3ds.que.common.web.entity.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2023/03/15
 */
@Data
public class QuestSortForm {

    @NotNull(message = "key请求异常")
    private String templateId;

    @NotNull(message = "key请求异常")
    private String moduleId;

    @NotNull(message = "key请求异常")
    private String queId;

    private Long beforePosition;

    private Long afterPosition;
}
