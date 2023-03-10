package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.center.entity.form.AnswerForm;
import com.m3ds.que.center.entity.form.AnswerQueryForm;
import com.m3ds.que.center.entity.param.AnswerQueryParam;
import com.m3ds.que.center.entity.po.Answer;
import com.m3ds.que.center.service.IAnswerService;
import com.m3ds.que.common.core.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 回答结果controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/psyquestioner/answer")
public class AnswerController {

    @Resource
    private IAnswerService answerServiceImpl;

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询回答结果
     */
    @ApiOperation(value = "查询回答结果", notes = "根据id查找回答结果")
    @ApiImplicitParam(paramType = "path", name = "id", value = "回答结果id", required = true, dataType = "string")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) {
        return Result.success(answerServiceImpl.getById(id));
    }

    /**
     * @param answerQueryForm 回答结果查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件分页查询问卷结果
     */
    @ApiOperation(value = "分页回答结果", notes = "带参数分页查询回答结果")
    @ApiImplicitParam(name = "answerQueryForm", value = "回答结果的实体", required = true, dataType = "AnswerQueryForm")
    @PostMapping("/conditions")
    public Result search(@Valid @RequestBody AnswerQueryForm answerQueryForm) {
        QueryWrapper<Answer> queryWrapper = answerQueryForm.toParam(AnswerQueryParam.class).build();
        return Result.success(answerServiceImpl.page(answerQueryForm.getPage(), queryWrapper));
    }

    /**
     * @param answerQueryParam 回答结果查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询问卷结果
     */
    @ApiOperation(value = "带查询条件查询问卷结果", notes = "带查询条件查询问卷结果")
    @ApiImplicitParam(name = "answerQueryParam", value = "回答结果的实体", required = true, dataType = "AnswerQueryParam")
    @GetMapping
    public Result query(@RequestParam AnswerQueryParam answerQueryParam) {
        QueryWrapper<Answer> queryWrapper = answerQueryParam.build();
        return Result.success(answerServiceImpl.list(queryWrapper));
    }

    /**
     * @param answerForm 要保存的回答结果对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存回答结果
     */
    @ApiOperation(value = "保存回答结果", notes = "保存回答结果")
    @ApiImplicitParam(name = "answerForm", value = "回答结果的实体", required = true, dataType = "AnswerForm")
    @PostMapping
    public Result save(@RequestBody AnswerForm answerForm) {
        Answer answer = answerForm.toPo(Answer.class);
        answerServiceImpl.save(answer);
        return Result.success();
    }

    /**
     * @param answerForm 要更新的回答结果对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新回答结果
     */
    @ApiOperation(value = "更新回答结果", notes = "根据回答结果id更新回答结果")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "path", name = "id", value = "要修改的回答结果id", required = true, dataType = "string"),
            @ApiImplicitParam(name = "answerForm", value = "回答结果实体", required = true, dataType = "AnswerForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody AnswerForm answerForm) {
        Answer answer = answerForm.toPo(Answer.class);
        answer.setId(id);
        answerServiceImpl.updateById(answer);
        return Result.success();
    }

    /**
     * @param id 要删除的回答结果id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个回答结果
     */
    @ApiOperation(value = "删除一个回答结果", notes = "根据id来删除一个回答结果")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要删除的回答结果id", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        answerServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param ids 回答结果的id列表
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:57
     * @description 批量删除回答结果
     */
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        answerServiceImpl.removeByIds(ids);
        return Result.success();
    }

}
