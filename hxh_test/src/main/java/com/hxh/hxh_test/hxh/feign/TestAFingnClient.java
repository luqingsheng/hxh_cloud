package com.hxh.hxh_test.hxh.feign;

import com.hxh.hxh_test.hxh.feign.fallback.TestAFingnClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用类
 */
@FeignClient(name = "HXH-BTEST",fallback = TestAFingnClientFallback.class)
public interface TestAFingnClient {

    @RequestMapping(value = "/btest/abcdb/bbb",method = RequestMethod.GET)
     String getStrTest(@RequestParam("aaa") String aaa);
}
