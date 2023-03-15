package com.m3ds.que.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface ModuleMapper extends BaseMapper<Module> {

    List<ModuleVo> queryAllByTemplate(String id);
}
