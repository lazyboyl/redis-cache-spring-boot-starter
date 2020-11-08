package com.lazyboyl.cache.example.service;

import com.lazyboyl.cache.annotation.RedisCacheConfig;
import com.lazyboyl.cache.annotation.RedisCacheMethod;
import org.springframework.stereotype.Service;

@Service
@RedisCacheConfig
public class TestService {


    @RedisCacheMethod("asdsadsa")
    public String testAbc(String a) {
        return "ada";
    }

}
