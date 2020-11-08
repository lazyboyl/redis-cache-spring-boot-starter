package com.lazyboyl.cache.annotation;

import java.lang.annotation.*;

/**
 * @author linzef
 * @since 2020-11-08
 * 类描述： 方法别名定义的注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCacheMethod {

    /**
     * 方法的名称
     *
     * @return
     */
    String value() default "";

}
