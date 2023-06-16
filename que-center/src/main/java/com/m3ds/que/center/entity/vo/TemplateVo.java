package com.m3ds.que.center.entity.vo;


import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.common.web.entity.vo.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * tangzheng
 * 问卷模板Vo类
 */
@Data
@NoArgsConstructor
public class TemplateVo extends BaseVo<Template> {

    public TemplateVo(Template template){
        BeanUtils.copyProperties(template, this);
    }

    /**
     * 受试者问卷Id
     */
    private String subjectQueId;

    /**
     * 受试者Id
     */
    private String subjectId;


    /**
     * 模板名
     */
    private String templateName;

    /**
     * 模板介绍
     */
    private String description;


    /**
     * 问卷状态
     */
    private Integer state;


    public TemplateVo(String id, String subjectQueId, String subjectId, String templateName, String description, Integer state) {
        this.setId(id);
        this.subjectQueId = subjectQueId;
        this.subjectId = subjectId;
        this.templateName = templateName;
        this.description = description;
        this.state = state;
    }
}
