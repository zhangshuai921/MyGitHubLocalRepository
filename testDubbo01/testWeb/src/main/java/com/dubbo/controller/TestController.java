package com.dubbo.controller;

import com.testDubbo.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: testDubbo01
 * @description:
 * @author: zhangshuai
 * @create: 2018-11-09 16:37
 **/
@RestController
public class TestController {

    @Resource
    private TestService testServiceImpl;

    @RequestMapping(value = "/getData")
    public String getData(String name){
        String data = testServiceImpl.getData(name);
        System.out.println(data);
        return data;
    }

}
