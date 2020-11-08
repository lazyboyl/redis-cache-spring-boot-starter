package com.lazyboyl.cache.aop;

import com.lazyboyl.cache.util.RedisCache;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author linzef
 * @since 2020-11-06
 * 类描述： 缓存的切面类
 */
public class AdapterServiceCacheInterceptor implements MethodInterceptor {

    private RedisCache redisCache;

    public AdapterServiceCacheInterceptor(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("--------" + redisCache);
        // 执行相应的方法
        Object ret = methodInvocation.proceed();
        return ret;
    }
}
