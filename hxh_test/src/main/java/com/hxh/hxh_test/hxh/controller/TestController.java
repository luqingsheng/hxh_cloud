package com.hxh.hxh_test.hxh.controller;

import com.hxh.hxh_test.hxh.feign.TestAFingnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abcd")
public class TestController {

    @Autowired
    private TestAFingnClient testAFingnClient;

    @RequestMapping(value = "/aaa",method = RequestMethod.GET)
    public String aaa(String aaa) {
        //return aaa;
        return  testAFingnClient.getStrTest(aaa);
    }
}