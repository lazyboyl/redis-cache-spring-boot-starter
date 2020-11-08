package com.lazyboyl.cache.scanner;

import com.lazyboyl.cache.annotation.RedisCacheConfig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author linzef
 * @since 2020-11-06
 * 类描述： 缓存的注册类
 */
public class RedisCacheScannerRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {

    private Environment environment;

    private ResourceLoader resourceLoader;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(RedisCacheConfig.class.getName()));
        RedisCacheScanner scanner = new RedisCacheScanner(beanDefinitionRegistry);
        if (resourceLoader != null) {
            scanner.setResourceLoader(resourceLoader);
        }
        scanner.doScan("com.lazyboyl.cache");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
