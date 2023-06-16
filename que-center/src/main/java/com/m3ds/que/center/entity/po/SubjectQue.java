package com.m3ds.que.center.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

/**
 * Created by wjs on 2023/06/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@NoArgsConstructor
public class SubjectQue extends BasePo<SubjectQue> {

    private static final long serialVersionUID = 1L;

    public SubjectQue(String subjectId, String templateId, Integer state) {
        this.subjectId = subjectId;
        this.templateId = templateId;
        this.state = state;
    }

    /**
     * 受试者ID
     */
    private String subjectId;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 状态(0未完成，1进行中，2已完成未提交，3 已完成已提交)
     */
    private Integer state;

    @TableLogic
    private Boolean deleted;
}
