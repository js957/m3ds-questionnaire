package com.m3ds.que.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.center.entity.vo.AnswerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface AnswerMapper extends BaseMapper<Answer> {

    /**
     * @param subjectId  要保存的回答结果对象们
     * @param templateId 要保存的回答结果对象们
     * 根据受试者和模板查询问卷完整记录
     */
    List<AnswerVo> answerHistory(@Param("subjectId") String subjectId, @Param("templateId") String templateId);
}
