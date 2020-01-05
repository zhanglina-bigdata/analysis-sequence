package com.niu.sequence.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2020-01-03 11:01
 **/
@Configuration
public class RestTemplateConfig {
    @LoadBalanced()
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplate();
        return template;
    }
}
