package com.m3ds.que.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.m3ds.que.center.entity.po.Answer;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface IAnswerService extends IService<Answer> {

    /**
     * @param subjectId 要保存的回答结果对象们
     * @param templateId 要保存的回答结果对象们
     * 根据受试者和模板查询问卷完整记录
     * 返回的是一个{question:question对象,answer:answerValue}的list
     */
    List<Map<String, Object>> answerHistory(String subjectId, String templateId);
}
