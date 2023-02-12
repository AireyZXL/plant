package com.resico.plant.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Airey
 * @date 2023/2/2 17:58
 */
@Slf4j
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){

        return "我是啦啦啦";
    }



}
