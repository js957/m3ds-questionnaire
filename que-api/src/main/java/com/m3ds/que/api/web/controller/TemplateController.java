package com.m3ds.que.api.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.m3ds.que.api.annotation.Login;
import com.m3ds.que.center.entity.form.TemplateForm;
import com.m3ds.que.center.entity.form.TemplateQueryForm;
import com.m3ds.que.center.entity.param.TemplateQueryParam;
import com.m3ds.que.center.entity.po.Template;
import com.m3ds.que.center.entity.vo.TemplateVo;
import com.m3ds.que.center.service.ITemplateService;
import com.m3ds.que.common.core.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 回答模板controller
 *
 * @author tangzheng
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/psyquestioner/template")
public class TemplateController {
    @Resource
    private ITemplateService templateServiceImpl;

    /**
     * @param id 表主键
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:52
     * @description 根据id查询回答模板
     */
    @ApiOperation(value = "查询回答模板", notes = "根据id查找回答模板")
    @ApiImplicitParam(paramType = "path", name = "id", value = "回答模板id", required = true, dataType = "string")
    @GetMapping("/{id}")
    @Login
    public Result get(@PathVariable String id) {
        Template template = templateServiceImpl.getById(id);
        if (template == null) {
            return Result.fail("找不到指定数据！");
        }
        return Result.success(new TemplateVo(template));
    }

    /**
     * @param templateQueryForm 回答模板查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询参数分页查询回答模板
     */
    @ApiOperation(value = "分页查询回答模板", notes = "带参数分页查询回答模板")
    @ApiImplicitParam(paramType = "body", name = "templateQueryForm", value = "回答模板的实体", required = true, dataType = "TemplateQueryForm")
    @PostMapping("/conditions")
    @Login
    public Result conditions(@RequestBody @Valid TemplateQueryForm templateQueryForm) {
        QueryWrapper<Template> queryWrapper = templateQueryForm.toParam(TemplateQueryParam.class).build();
        Page page = templateServiceImpl.page(templateQueryForm.getPage(), queryWrapper);
        return Result.success(page.setRecords((List) page.getRecords().stream().map(t -> new TemplateVo((Template) t)).collect(Collectors.toList())));
    }

    /**
     * @param templateQueryParam 回答模板查询条件
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:54
     * @description 带查询条件查询回答模板
     */
    @ApiOperation(value = "带查询条件查询回答模板", notes = "带查询条件查询回答模板")
    @ApiImplicitParam(paramType = "query", name = "templateQueryParam", value = "回答模板的实体", required = true, dataType = "TemplateQueryParam")
    @GetMapping
    @Login
    public Result query(@Valid TemplateQueryParam templateQueryParam) {
        QueryWrapper<Template> queryWrapper = templateQueryParam.build();
        return Result.success((templateServiceImpl.list(queryWrapper).stream().map(TemplateVo::new)).collect(Collectors.toList()));
    }

    /**
     * @param templateForm 要保存的回答模板对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 保存回答模板
     */
    @ApiOperation(value = "保存回答模板", notes = "保存回答模板")
    @ApiImplicitParam(paramType = "body", name = "templateForm", value = "回答模板的实体", required = true, dataType = "TemplateForm")
    @PostMapping
    @Login
    public Result save(@RequestBody @Valid TemplateForm templateForm) {
        Template template = templateForm.toPo(Template.class);
        templateServiceImpl.save(template);
        return Result.success(template.getId());
    }

    /**
     * @param templateForm 要更新的回答模板对象
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 14:55
     * @description 更新回答模板
     */
    @ApiOperation(value = "更新回答模板", notes = "根据回答模板id更新回答模板")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "要修改的回答模板id", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "body", name = "templateForm", value = "回答模板实体", required = true, dataType = "TemplateForm")
    })
    @PutMapping(value = "/{id}")
    @Login
    public Result update(@PathVariable String id, @RequestBody TemplateForm templateForm) {
        Template template = templateForm.toPo(Template.class);
        template.setId(id);
        templateServiceImpl.updateById(template);
        return Result.success();
    }

    /**
     * @param id 要删除的回答模板id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 删除一个回答模板
     */
    @ApiOperation(value = "删除一个回答模板", notes = "根据id来删除一个回答模板")
    @ApiImplicitParam(paramType = "path", name = "id", value = "要删除的回答模板id", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    @Login
    public Result delete(@PathVariable String id) {
        templateServiceImpl.removeById(id);
        return Result.success();
    }

    /**
     * @param subjectId 受试者id
     * @return com.m3ds.que.common.core.vo.Result
     * @author tangzheng
     * @date 2023/3/10 16:55
     * @description 根据受试者查模板列表
     */
    @GetMapping(value = "/history/{subjectId}")
    @Login
    public Result queryHistoryBySubjectId(@PathVariable String subjectId) {
        List<TemplateVo> templateList = templateServiceImpl.queryHistoryBySubjectId(subjectId);
        return Result.success(templateList);
    }

}
