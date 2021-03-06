package com.lazyboyl.cache.example.controller;

import com.lazyboyl.cache.annotation.RedisCacheConfig;
import com.lazyboyl.cache.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RedisCacheConfig
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("test")
    public String test() {
        return testService.testAbc("adsasda");
    }

}
