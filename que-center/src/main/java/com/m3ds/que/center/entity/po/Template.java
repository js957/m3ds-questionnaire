package com.m3ds.que.center.entity.po;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
public class Template extends BasePo<Template> {

    private static final long serialVersionUID = 1L;

    /**
     * 模板名
     */
    private String templateName;

    /**
     * 模板介绍
     */
    private String description;


    @TableLogic
    private Boolean deleted;
}
