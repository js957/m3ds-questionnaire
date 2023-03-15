package com.m3ds.que.api.web.controller;


import com.m3ds.que.center.entity.form.QuestSortForm;
import com.m3ds.que.center.entity.form.QuestionForm;
import com.m3ds.que.center.entity.param.QueListQueryParam;
import com.m3ds.que.common.core.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/question")
public class QuestionController {

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 创建问题
    */
    @PostMapping("/create")
    public Result create(@RequestBody QuestionForm questionForm){
        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 删除问题
    */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 修改问题
    */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @RequestBody QuestionForm questionForm){
        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 17:47
     * 获取问题
    */
    @GetMapping("/{id}")
    public Result get(@PathVariable String id){
        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 21:47
     * 修改顺序
    */
    @PostMapping("/sort")
    public Result sort(@RequestBody QuestSortForm questSortForm){
        return null;
    }

    /**
    *@Param:
    *@Author: wjs
    *@date: 21:47
     * 获取一个模块的所有问题
    */
    @GetMapping("/list")
    public Result list(@RequestBody QueListQueryParam queListQueryParam){
        return null;
    }




}
