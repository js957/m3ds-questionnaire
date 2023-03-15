package com.m3ds.que.center.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.common.web.entity.param.BaseParam;
import lombok.Data;
import org.springframework.util.StringUtils;

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
        queryWrapper.eq(!StringUtils.isEmpty(this.templateId), "template_id", this.templateId);
        queryWrapper.like(!StringUtils.isEmpty(this.moduleName), "module_name", this.moduleName);
        queryWrapper.eq(!StringUtils.isEmpty(this.moduleNo), "module_no", this.moduleNo);
        queryWrapper.eq(this.sorted != null, "sorted", this.sorted);
        queryWrapper.orderBy(true, false, "sorted").orderBy(true, true, "serial_num");
        return queryWrapper;
    }
}
