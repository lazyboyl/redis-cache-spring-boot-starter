package com.lazyboyl.cache.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCacheConfig {

    /**
     * 方法的名称
     *
     * @return
     */
    String value() default "";

}
