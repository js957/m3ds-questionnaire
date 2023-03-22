package com.m3ds.que.center.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.common.web.entity.vo.BaseVo;
import com.m3ds.que.common.web.handler.JacksonTypeHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * tangzheng
 * 问题在app上的vo类
 */
@Data
@NoArgsConstructor
@TableName(value = "question", autoResultMap = true)
public class QuestionAppVo extends BaseVo<Question> {

    public QuestionAppVo(Question question){
        BeanUtils.copyProperties(question, this);
    }

    /**
     * 问题的编号用于线索
     */
    private String questionNo;

    /**
     * 问题类型，0是问题1是诊断框
     */
    private Integer queType;

    /**
     * 可选 CHECKBOX,RADIO,INPUT,TEXT
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
     * 提醒该题目由谁作答
     */
    private Integer answers;

    /**
     * 选项
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String,Object> optData;

    /**
     * 跳转规则
     */
    private List<SkipAppVo> skipRules;

    /**
     * 需要参考的题目列表
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> refIds;

}
