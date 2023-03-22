package com.m3ds.que.center.entity.vo;

import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.common.web.entity.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * tangzheng
 * 问卷模快Vo类
 */
@Data
@NoArgsConstructor
public class ModuleVo extends BaseVo<Module> {

    public ModuleVo(Module module) {
        BeanUtils.copyProperties(module, this);
    }

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
     * 模块说明
     */
    private String description;

    /**
     * 判断模块是否加入顺序队列
     */
    private Boolean sorted;

    /**
     * 排序序号
     */
    private Integer serialNum;

}
