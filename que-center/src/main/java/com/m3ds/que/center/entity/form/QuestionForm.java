package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.common.web.entity.form.BaseForm;
import com.m3ds.que.common.web.validator.group.AddGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Created by wjs on 2023/03/15
 */
@Data
public class QuestionForm extends BaseForm<Question> {

    /**
     * 问题属于哪个模块
     */
    @NotNull(message = "key请求异常",groups = {AddGroup.class})
    private String moduleId;

    /**
     * 模块编号用于显示
     */
    @NotNull(message = "请求异常",groups = {AddGroup.class})
    private String moduleNo;

    /**
     * 问题的编号用于线索
     */
    private String questionNo;

    /**
     * 问题类型(0问题，1诊断框问题，2诊断框子问题)
     */
    @NotNull(message = "问题类型必选",groups = {AddGroup.class})
    private Integer queType;


    /**
     * 选项类型(TEXT,INPUT,RADIO,CHECKBOX)
     */
    @NotNull(message = "选项类型必填",groups = {AddGroup.class})
    private String optType;


    /**
     * 问题
     */
    @NotNull(message = "问题内容不为空",groups = {AddGroup.class})
    private String issue;

    /**
     * 问题补充
     */
    private String note;

    /**
     * 提醒改题目由谁作答
     */
    @NotNull(message = "指定回答人",groups = {AddGroup.class})
    private Integer answers;

    /**
     * 选项
     */
    private Map<String, Object> optData;

    /**
     * 参考规则
     */
    private List<String> refIds;

    /**
     * 排序序号
     */
    @NotNull(message = "序号不为空")
    private Long serialNum;

    /**
     * 跳转规则列表
     */
    private List<SkipForm> skipRules;

}
