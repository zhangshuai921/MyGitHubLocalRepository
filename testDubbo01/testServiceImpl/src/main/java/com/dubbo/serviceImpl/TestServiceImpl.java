package com.dubbo.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.testDubbo.TestService;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: testDubbo01
 * @description:
 * @author: zhangshuai
 * @create: 2018-11-09 17:13
 **/
@Service
public class TestServiceImpl implements TestService{

    public String getData(String name) {
        return "你传递的参数我收到了是"+name;
    }

}
