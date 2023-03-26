package com.m3ds.que.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.center.entity.vo.TemplateVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface TemplateMapper extends BaseMapper<Template> {

    /**
     * @param subjectId 受试者id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 根据受试者查模板列表
     */
    List<TemplateVo> queryHistoryBySubjectId(String subjectId);
}
