package com.lazyboyl.cache.scanner;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author linzef
 * @since 2020-11-06
 * 类描述： 缓存的注册类
 */
public class RedisCacheScannerRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        RedisCacheScanner scanner = new RedisCacheScanner(beanDefinitionRegistry);
        scanner.doScan("com.lazyboyl.cache");
    }
}
