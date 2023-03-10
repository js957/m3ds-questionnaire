package com.m3ds.que.center.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.common.web.entity.param.BaseParam;
import lombok.Data;

/**
 * tangzheng
 * 问卷结果Param类
 */
@Data
public class AnswerQueryParam extends BaseParam<Answer> {

    /**
     * 受试者id
     */
    private String subId;

    /**
     * 问题id
     */
    private String queId;

    /**
     * 问题提交答案0，	诊断框提交答案1，	问题子问题提交答案2，	诊断框子问题提交答案3
     */
    private Integer type;

    @Override
    public QueryWrapper<Answer> build() {
        QueryWrapper<Answer> queryWrapper = super.build();
        queryWrapper.eq("sub_id", this.subId);
        queryWrapper.eq("que_id", this.queId);
        queryWrapper.eq("type", this.type);
        return queryWrapper;
    }

}
