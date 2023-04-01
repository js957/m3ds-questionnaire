package com.m3ds.que.center.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.center.entity.po.Question;
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
 * 问题vo
 */
@Data
@NoArgsConstructor
@TableName(value = "question", autoResultMap = true)
public class QuestionVo extends BaseVo<Question> {

    public QuestionVo(Question question) {
        BeanUtils.copyProperties(question, this);
    }

    /**
     * moduleNo
     */
    private String moduleNo;

    /**
     * 问题的编号用于线索
     */
    private String questionNo;

    /**
     * 问题类型(0问题，1诊断框问题，2诊断框子问题)
     */
    private Integer queType;


    /**
     * 选项类型(TEXT,INPUT,RADIO,CHECKBOX)
     */
    private String optType;


    /**
     * 问题
     */
    private String issue;

    /**
     * 问题补充
     */
    private String note;

    /**
     * 提醒改题目由谁作答
     */
    private Integer answers;

    /**
     * 选项
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> optData;

    /**
     * 跳转规则
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<SkipVo> skipRules;

    /**
     * 参考题目
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> refIds;

    /**
     * 序号
     */
    private Long serialNum;
}
