package com.m3ds.que.center.entity.vo;


import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.center.entity.po.Template;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * tangzheng
 * 问卷模板Vo类
 */
@Data
@NoArgsConstructor
public class TemplateVo {

    public TemplateVo(Template template){
        BeanUtils.copyProperties(template, this);
    }

    /**
     * 模板名
     */
    private String templateName;

    /**
     * 模板介绍
     */
    private String description;


}
