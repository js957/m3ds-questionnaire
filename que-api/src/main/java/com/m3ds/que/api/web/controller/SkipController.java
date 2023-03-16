package com.m3ds.que.api.web.controller;


import com.m3ds.que.center.entity.form.SkipForm;
import com.m3ds.que.common.core.vo.Result;
import com.m3ds.que.common.web.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/skip")
public class SkipController {

    /**
    *@Param:
    *@Author: wjs
    *@date: 20:28
     * 创建跳转规则
    */
    @PostMapping
    public Result create(@RequestBody SkipForm skipForm){
        ValidatorUtils.validateEntity(skipForm);

        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 20:36
     * 删除跳转规则
    */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 21:00
     * 修改跳转规则
    */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @RequestBody SkipForm skipForm){
        return null;
    }


}
