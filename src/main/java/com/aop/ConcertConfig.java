package com.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/29 17:10
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy   // 启用aspect自动代理
@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience(){
        return new Audience();
    }


    @Bean
    public Performance performance(){
        return new Performance();
    }

    @Bean("audienceXML")
    public AudienceXML audienceXML(){
        return new AudienceXML();
    }
}
