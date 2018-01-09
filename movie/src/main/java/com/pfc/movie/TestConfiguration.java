package com.pfc.movie;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yawei on 2018/1/9.
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
    //  @Autowired
    //  IClientConfig config;

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}