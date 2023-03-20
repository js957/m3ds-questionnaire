package com.m3ds.que.center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.m3ds.que.center.entity.po.Question;
import com.m3ds.que.center.entity.vo.QuestionVo;
import com.m3ds.que.center.mapper.QuestionMapper;
import com.m3ds.que.center.service.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    /**
     * @param id 问题表主键
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询问题(包括之下的skip)
     */
    @Override
    public QuestionVo queryQuestionWithSkip(String id) {
        return baseMapper.queryQuestionWithSkip(id);
    }

    /**
     * @param moduleId 模块表主键
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据模块id查询问题(包括之下的skip)
     */
    @Override
    public List<QuestionVo> queryByModule(String moduleId) {
        return baseMapper.queryByModule(moduleId);
    }
}
