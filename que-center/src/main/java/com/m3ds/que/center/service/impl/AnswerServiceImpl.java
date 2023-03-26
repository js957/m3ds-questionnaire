package com.m3ds.que.center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.vo.AnswerVo;
import com.m3ds.que.center.entity.vo.QuestionVo;
import com.m3ds.que.center.mapper.AnswerMapper;
import com.m3ds.que.center.mapper.QuestionMapper;
import com.m3ds.que.center.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {

    @Resource
    private QuestionMapper questionMapper;

    /**
     * @param subjectId  要保存的回答结果对象们
     * @param templateId 要保存的回答结果对象们
     *                   根据受试者和模板查询问卷完整记录
     *                   返回的是一个{question:question对象,answer:answerValue}的list
     */
    @Override
    public List<Map<String, Object>> answerHistory(String subjectId, String templateId) {
        List<AnswerVo> answers = baseMapper.answerHistory(subjectId, templateId);
        Map<String, Map<String, Object>> map = new HashMap<>();
        for (AnswerVo answer : answers) {
            map.put(answer.getModuleId(), answer.getQueResult());
        }
        List<Question> questions = questionMapper.questionListByTemplate(templateId);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Question question : questions) {
            Map<String, Object> tMap3 = map.get(question.getModuleId());
            if (tMap3 != null) {
                Object tObj2 = tMap3.get(question.getId());
                if (tObj2 != null) {
                    Map<String, Object> tMap2 = (Map<String, Object>) tObj2;
                    Map<String, Object> tMap = new HashMap<>();
                    tMap.put("question", new QuestionVo(question));
                    tMap.put("value", tMap2.get("value"));
                    resultList.add(tMap);
                }
            }
        }
        return resultList;
    }
}
