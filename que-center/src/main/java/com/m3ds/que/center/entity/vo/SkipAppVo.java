package com.m3ds.que.center.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.common.web.entity.vo.BaseVo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * tangzheng
 * 跳转规则在App上的vo类
 */
@Data
@NoArgsConstructor
@TableName(value = "skip", autoResultMap = true)
public class SkipAppVo extends BaseVo<Skip> {

    public SkipAppVo(Skip skip){
        BeanUtils.copyProperties(skip, this);
    }

    /**
     * 诊断程序描述
     */
    private String description;

    /**
     * 1：按各题选项跳转，2：按答题分数跳转，3：按选中数量跳转
     */
    private Integer type;

    /**
     * 跳转目标id
     */
    private String target;

    /**
     * 跳转条件
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> conditionJson;

}
