package com.m3ds.que.center.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.common.web.entity.vo.BaseVo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * tangzheng
 * 跳转规则vo类
 */
@Data
@NoArgsConstructor
@TableName(value = "skip", autoResultMap = true)
public class SkipVo extends BaseVo<Skip> {

    public SkipVo(Skip skip){
        BeanUtils.copyProperties(skip, this);
    }

    /**
     * 诊断程序描述
     */
    private String description;

    /**
     * 跳转至题目为0	跳转至诊断框为1	跳转至子问题为2	跳转至模块为3	跳转至诊断程序问题4
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
