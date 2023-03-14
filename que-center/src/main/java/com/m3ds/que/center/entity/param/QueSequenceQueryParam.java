package com.m3ds.que.center.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.po.QueSequence;
import com.m3ds.que.common.web.entity.param.BaseParam;
import lombok.Data;

/**
 * tangzheng
 * 模板问题顺序Param类
 */
@Data
public class QueSequenceQueryParam extends BaseParam<QueSequence> {

    /**
     * 模块id
     */
    private String moduleId;

    /**
     * 所属模块编号
     */
    private String moduleNo;

    /**
     * 问题或诊断框id或诊断程序(跳转)
     */
    private String queId;

    /**
     * 0为问题，1为诊断框，2为诊断程序
     */
    private Integer type;

    @Override
    public QueryWrapper<QueSequence> build() {
        QueryWrapper<QueSequence> queryWrapper = super.build();
        queryWrapper.eq(this.moduleId != null, "module_id", this.moduleId);
        queryWrapper.eq(this.moduleNo != null, "module_no", this.moduleNo);
        queryWrapper.eq(this.queId != null, "que_id", this.queId);
        queryWrapper.eq(this.type != null, "type", this.type);
        return queryWrapper;
    }
}
