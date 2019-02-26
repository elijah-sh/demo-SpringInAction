package com.web.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/12/4 09:12
 * @Description: 用非Web的组件来充实完善RootConfig。
 */
@Configuration
@ComponentScan(basePackages = {"com.web.spittr"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
}
