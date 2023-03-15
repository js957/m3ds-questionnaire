package com.m3ds.que.center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleVo;
import com.m3ds.que.center.mapper.ModuleMapper;
import com.m3ds.que.center.service.IModuleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * tangzheng
 * 问卷模块service实现类
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    @Override
    public List<ModuleVo> queryAllByTemplate(String id) {
        return baseMapper.queryAllByTemplate(id);
    }
}
