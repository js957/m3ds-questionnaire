package com.m3ds.que.center.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.common.web.entity.param.BaseParam;
import lombok.Data;

/**
 * tangzheng
 * 问卷模块Param类
 */
@Data
public class ModuleQueryParam extends BaseParam<Module> {

    /**
     * 所属问卷模板
     */
    private String templateId;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 模块编号
     */
    private String moduleNo;

    /**
     * 判断模块中的题目是否加入顺序队列
     */
    private Boolean sorted;

    @Override
    public QueryWrapper<Module> build() {
        QueryWrapper<Module> queryWrapper = super.build();
        queryWrapper.eq(this.templateId != null, "template_id", this.templateId);
        queryWrapper.like(this.moduleName != null, "module_name", this.moduleName);
        queryWrapper.eq(this.moduleNo != null, "module_no", this.moduleNo);
        queryWrapper.eq(this.sorted != null, "sorted", this.sorted);
        queryWrapper.orderBy(true, false, "sorted").orderBy(true, true, "serial_num");
        return queryWrapper;
    }
}
