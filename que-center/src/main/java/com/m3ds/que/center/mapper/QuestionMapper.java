package com.m3ds.que.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.vo.QuestionVo;

import java.util.List;

/**
 * tangzheng
 * 问题
 */
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * @param id 问题表主键
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询问题(包括之下的skip)
     */
    QuestionVo queryQuestionWithSkip(String id);

    /**
     * @param moduleId 模块表主键
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据模块id查询问题(包括之下的skip)
     */
    List<QuestionVo> queryByModule(String moduleId);
}
