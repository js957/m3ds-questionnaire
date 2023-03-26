package com.m3ds.que.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.center.entity.vo.TemplateVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface ITemplateService extends IService<Template> {

    /**
     * @param subjectId 受试者id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 根据受试者查模板列表
     */
    List<TemplateVo> queryHistoryBySubjectId(String subjectId);
}
