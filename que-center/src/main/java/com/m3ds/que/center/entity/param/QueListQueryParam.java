package com.m3ds.que.center.entity.param;

import com.m3ds.que.common.web.entity.form.BaseQueryForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by wjs on 2023/03/15
 */
@Data
public class QueListQueryParam extends BaseQueryForm {

    @NotNull(message = "key请求异常")
    private String templateId;

    @NotNull(message = "key请求异常")
    private String moduleId;

}
