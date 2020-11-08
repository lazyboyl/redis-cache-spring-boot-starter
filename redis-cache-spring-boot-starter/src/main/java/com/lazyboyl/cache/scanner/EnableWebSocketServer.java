package com.lazyboyl.cache.scanner;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author linzef
 * @since 2020-03-16
 * 注解描述： 实现开启netty服务
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({RedisCacheScannerRegister.class})
public @interface EnableWebSocketServer {

}
