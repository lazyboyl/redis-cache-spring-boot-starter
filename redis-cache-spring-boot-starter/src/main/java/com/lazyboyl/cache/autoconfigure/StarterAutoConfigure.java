package com.lazyboyl.cache.autoconfigure;

import com.lazyboyl.cache.aop.AdapterServiceAdvisor;
import com.lazyboyl.cache.aop.AdapterServiceCacheInterceptor;
import com.lazyboyl.cache.scanner.RedisCacheScannerRegister;
import com.lazyboyl.cache.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author linzf
 * @since 2020/9/21
 * 类描述：
 */
@Configuration
@Import({RedisCacheScannerRegister.class})
@ConditionalOnProperty(
        prefix = "redis.cache",
        name = "enable",
        havingValue = "true"
)
public class StarterAutoConfigure {

    @Value("${redis.cache.expression}")
    private String expression;

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;


    @Bean(name = "adapterServiceAdvisor")
    public AdapterServiceAdvisor adapterServiceAdvisor() {
        AdapterServiceAdvisor advisor = new AdapterServiceAdvisor(expression);
        advisor.setAdviceBeanName("adapterServiceAdvice");
        advisor.setAdvice(new AdapterServiceCacheInterceptor(new RedisCache(redisTemplate)));
        advisor.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return advisor;
    }
}
