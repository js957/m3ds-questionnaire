package com.m3ds.que.center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleAppVo;
import com.m3ds.que.center.entity.vo.ModuleVo;
import com.m3ds.que.center.mapper.ModuleMapper;
import com.m3ds.que.center.service.IModuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * tangzheng
 * 问卷模块service实现类
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    /**
     * @param templateId 模板id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块信息以及问题信息
     */
    @Override
    public List<ModuleAppVo> queryAllByTemplate(String templateId) {
        return baseMapper.queryAllByTemplate(templateId);
    }

    /**
     * @param templateId 模板id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id, no)以及问题(id, no)
     */
    @Override
    public List<Map<String, Object>> querySimplifiedTree(String templateId) {
        return baseMapper.querySimplifiedTree(templateId);
    }

    /**
     * @param templateId 模板id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id,no)以及下属的单选题(id,no),除此之外问题将附带conditionJson
     */
    @Override
    public List<Map<String, Object>> querySimplifiedTreeForSkip(String templateId) {
        return baseMapper.querySimplifiedTreeForSkip(templateId);
    }

    @Override
    public List<Map<String, Object>> querySimplifiedTreeByModule(String moduleId) {
        return baseMapper.querySimplifiedTreeByModule(moduleId);
    }

    @Override
    public List<Map<String, Object>> querySimplifiedTreeForSkipByModule(String moduleId) {
        return baseMapper.querySimplifiedTreeForSkipByModule(moduleId);
    }
}
