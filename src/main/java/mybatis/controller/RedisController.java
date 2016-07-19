package mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import mybatis.service.RedisCacheUtil;

/**
 * Created with IntelliJ IDEA.
 * User: jiagf
 * Date: 16-7-18
 * Time: 下午11:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisCacheUtil redisCacheUtil;

    @RequestMapping(value = "/testRedis")
    public String testRedis(){
        redisCacheUtil.setCacheObject("testkey11111", "testkey11111")   ;
        return (String)redisCacheUtil.getCacheObject("testkey11111");
    }
}
