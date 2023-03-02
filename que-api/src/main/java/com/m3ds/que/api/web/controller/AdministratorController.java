package com.m3ds.que.api.web.controller;


import com.m3ds.que.common.core.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/account")
public class AdministratorController {

    @GetMapping(value = "/{id}")
    public Result test(@PathVariable String id){
        System.out.println(id);
        return Result.fail();
    }
}
