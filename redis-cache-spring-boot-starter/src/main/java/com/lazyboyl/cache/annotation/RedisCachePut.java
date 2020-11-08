package com.lazyboyl.cache.annotation;

import java.lang.annotation.*;

/**
 * @author linzef
 * @since 2020-11-08
 * 类描述： 将数据保存到redis缓存中的注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCachePut {

    /**
     * 缓存的命名空间
     *
     * @return
     */
    String value() default "";

    /**
     * 缓存到redis中的key
     *
     * @return
     */
    String key() default "";

    /**
     * 调用指定方法进行缓存的方法名称
     *
     * @return
     */
    String cacheMethodName() default "";

}
