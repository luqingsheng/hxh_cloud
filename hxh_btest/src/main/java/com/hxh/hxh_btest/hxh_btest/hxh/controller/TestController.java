package com.hxh.hxh_btest.hxh_btest.hxh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abcdb")
public class TestController {

    @RequestMapping(value = "/bbb",method = RequestMethod.GET)
    public String aaa(String aaa) {
        String s = null;
        return "我是btest的aaa的返回！==》》》="+aaa;
    }
}