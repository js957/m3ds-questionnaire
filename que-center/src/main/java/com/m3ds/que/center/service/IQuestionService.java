package com.m3ds.que.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.vo.QuestionVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface IQuestionService extends IService<Question> {

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
