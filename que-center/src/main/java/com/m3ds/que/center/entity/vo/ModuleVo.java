package com.m3ds.que.center.entity.vo;

import com.m3ds.que.center.entity.po.Module;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * tangzheng
 * 问卷模快Vo类
 */
@Data
@NoArgsConstructor
public class ModuleVo {

    public ModuleVo(Module module){
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
     * 判断模块中的题目是否加入顺序队列
     */
    private Boolean sorted;


}
