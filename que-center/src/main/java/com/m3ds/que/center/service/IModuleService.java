package com.m3ds.que.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleAppVo;
import com.m3ds.que.center.entity.vo.ModuleVo;

import java.util.List;
import java.util.Map;

/**
 * tangzheng
 * 问卷模块service
 */
public interface IModuleService extends IService<Module> {
    /**
     * @param templateId 模板id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块信息以及问题信息
     */
    List<ModuleAppVo> queryAllByTemplate(String templateId);

    /**
     * @param templateId 模板id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id,no)以及问题(id,no)
     */
    List<Map<String, Object>> querySimplifiedTree(String templateId);

    /**
     * @param templateId 模板id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id,no)以及下属的单选题(id,no),除此之外问题将附带conditionJson
     */
    List<Map<String, Object>> querySimplifiedTreeForSkip(String templateId);


    /**
     * @param moduleId 模块id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id,no)以及问题(id,no)
     */
    List<Map<String, Object>> querySimplifiedTreeByModule(String moduleId);

    /**
     * @param templateId 模块id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id,no)以及下属的单选题(id,no),除此之外问题将附带conditionJson
     */
    List<Map<String, Object>> querySimplifiedTreeForSkipByModule(String moduleId);
}
