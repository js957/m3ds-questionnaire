package com.m3ds.que.center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.center.entity.vo.TemplateVo;
import com.m3ds.que.center.mapper.TemplateMapper;
import com.m3ds.que.center.service.ITemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements ITemplateService {

    @Override
    public List<TemplateVo> queryHistoryBySubjectId(String subjectId) {
        return baseMapper.queryHistoryBySubjectId(subjectId);
    }
}
