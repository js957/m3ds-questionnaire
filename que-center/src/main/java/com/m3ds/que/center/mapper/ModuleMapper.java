package com.m3ds.que.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.m3ds.que.center.entity.po.Module;
import com.m3ds.que.center.entity.vo.ModuleAppVo;
import com.m3ds.que.center.entity.vo.ModuleVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
public interface ModuleMapper extends BaseMapper<Module> {

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
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id, no)以及问题(id, no)
     */
    List<Map<String, Object>> querySimplifiedTree(String templateId);

    /**
     * @param templateId 模板id
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 根据模板id查询对应模板下的模块(id,no)以及下属的单选题(id,no),除此之外问题将附带conditionJson
     */
    List<Map<String, Object>> querySimplifiedTreeForSkip(String templateId);
}
