package com.m3ds.que.center.entity.po;

import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Decision extends BasePo<Decision> {

    private static final long serialVersionUID = 1L;

    /**
     * 根据问题id获取子问题
     */
    private String queId;

    /**
     * 0问题，1诊断框，2子问题
     */
    private Integer type;

    /**
     * 参考的ids
     */
    private String refIds;

    /**
     * 选择条件
     */
    private String condition;


}
