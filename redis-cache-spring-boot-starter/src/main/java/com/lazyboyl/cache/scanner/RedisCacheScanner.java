package com.lazyboyl.cache.scanner;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Set;

/**
 * @author linzf
 * @since 2020/11/06
 * 类描述： 缓存的扫描类
 */
public class RedisCacheScanner extends ClassPathBeanDefinitionScanner {

    public RedisCacheScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public RedisCacheScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    public RedisCacheScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment) {
        super(registry, useDefaultFilters, environment);
    }


    /**
     * 功能描述： 实现spring的的扫描注入
     *
     * @param basePackages
     * @return
     */
    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        if (beanDefinitions.isEmpty()) {
            logger.warn("No DgbSecurity Spring Componet was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
        }
        return beanDefinitions;
    }

}
