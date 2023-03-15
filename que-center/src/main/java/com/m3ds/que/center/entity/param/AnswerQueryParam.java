package com.m3ds.que.center.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.common.web.entity.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;

/**
 * tangzheng
 * 问卷结果Param类
 */
@ApiModel
@Data
public class AnswerQueryParam extends BaseParam<Answer> {

    /**
     * 受试者id
     */
    @ApiModelProperty(value = "受试者id")
    private String subId;

    /**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private String moduleId;

    @AssertTrue(message = "受试者信息和模块信息应至少有其中一项")
    private boolean isValid() {
        return subId != null || moduleId != null;
    }

    @Override
    public QueryWrapper<Answer> build() {
        QueryWrapper<Answer> queryWrapper = super.build();
        queryWrapper.eq(!StringUtils.isEmpty(this.subId), "sub_id", this.subId);
        queryWrapper.eq(!StringUtils.isEmpty(this.moduleId), "module_id", this.moduleId);
        return queryWrapper;
    }

}
