package com.hxh.hxh_test.hxh.feign.fallback;

import com.hxh.hxh_test.hxh.feign.TestAFingnClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestAFingnClientFallback implements TestAFingnClient {

    @Override
    public String getStrTest(String aaa) {
        log.error("hxh-btest connection error!!!!!!!!!!!!!!!!!!!!!!");
       /* Map map = new HashMap();
        map.put("code",1001);
        map.put("msg","用户皮肤测试远程调用失败");*/
        return "用户皮肤测试远程调用失败";
    }
}
