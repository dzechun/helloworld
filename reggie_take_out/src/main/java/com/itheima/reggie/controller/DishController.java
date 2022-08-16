package com.itheima.reggie.controller;

import com.itheima.reggie.com.R;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/dish")
public class DishController {

    @Resource
    private DishFlavorService dishFlavorService;

    @Resource
    private DishService dishService;

    @PostMapping("/save")
    public R<String> save(){
        return null;
    }
}
