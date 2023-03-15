package com.m3ds.que.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleVo;

import java.util.List;

/**
 * tangzheng
 * 问卷模块service
 */
public interface IModuleService extends IService<Module> {

    List<ModuleVo> queryAllByTemplate(String id);
}
