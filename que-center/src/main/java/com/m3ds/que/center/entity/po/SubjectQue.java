package com.m3ds.que.center.entity.po;

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
@AllArgsConstructor
@NoArgsConstructor
public class SubjectQue extends BasePo<SubjectQue> {

    private static final long serialVersionUID = 1L;

    /**
     * 受试者ID
     */
    private String subjectId;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 状态(0未完成，1进行中，2已完成)
     */
    private Integer state;
}
