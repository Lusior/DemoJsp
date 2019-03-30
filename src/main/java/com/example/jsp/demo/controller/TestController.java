package com.example.jsp.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @ResponseBody
    @GetMapping("/ok")
    public String ok() {
        System.out.println(activeProfile);
        return "ok";
    }

    @GetMapping("/")
    public String success(Map<String, Object> params) {
        params.put("hello", "<h2>你好</h2>");
        List<String> list = Arrays.asList("张三", "李四", "王五");
        params.put("users", list);
        return "index";
    }
}
