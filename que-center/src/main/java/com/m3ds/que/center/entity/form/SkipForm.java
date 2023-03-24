package com.m3ds.que.center.entity.form;

import com.m3ds.que.center.entity.po.Skip;
import com.m3ds.que.common.web.entity.form.BaseForm;
import com.m3ds.que.common.web.validator.group.AddGroup;
import com.m3ds.que.common.web.validator.group.UpdateGroup;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Created by wjs on 2023/03/15
 */
@Data
public class SkipForm extends BaseForm<Skip> {

    /**
     * 诊断程序描述
     */
    private String description;

    /**
     * 1：按各题选项跳转，2：按答题分数跳转，3：按选中数量跳转
     */
    @NotNull(message = "类型不许为空", groups = {AddGroup.class})
    private Integer type;

    /**
     * 根据问题id获取子问题
     */
    @NotNull(message = "绑定的问题id不允许为空", groups = {AddGroup.class})
    private String queId;

    /**
     * 跳转目标id
     */
    @NotNull(message = "跳转目标不允许为空")
    private String target;

    /**
     * type1:[{"value": 2, "questionId": "1636340836291145729"}]
     */
    @NotNull(message = "跳转条件不允许为空", groups = {AddGroup.class, UpdateGroup.class})
    private Map<String, Object> conditionJson;

    /**
     * type1:每个conditionJson的map都要指定选项和题目
     */
    @AssertTrue(message = "判断条件不合规，请检查是否存在未填选项")
    private Boolean isValid() {
        //没有条件，不行
        try {
            if (this.conditionJson.isEmpty()) {
                return false;
            }
            //判断复杂条件时
            if (this.type == 1) {
                List<Map<String, Object>> conditions = (List<Map<String, Object>>) this.conditionJson.get("conditions");
                if (conditions == null || conditions.size() == 0) {
                    return false;
                }
                //属性残缺，不行
                for (Map<String, Object> map : conditions) {
                    if (StringUtils.isEmpty((String) map.get("value")) || StringUtils.isEmpty((String) map.get("questionId"))) {
                        return false;
                    }
                }
            }
            //判断分数时
            if (this.type == 2) {
                List<String> questions = (List<String>) this.conditionJson.get("questions");
                Integer score = (Integer) this.conditionJson.get("questions");
                if (questions == null || questions.size() == 0 || score == null) {
                    return false;
                }
            }
            //判断选中数量时
            if (this.type == 3) {

            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
