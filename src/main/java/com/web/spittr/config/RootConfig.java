package com.web.spittr.config;

import com.web.spittr.config.security.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Pattern;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/12/4 09:12
 * @Description: 用非Web的组件来充实完善RootConfig。
 */
@ComponentScan(basePackages = {"com.web.spittr"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
//@Configuration
@Import({SecurityConfig.class})
@ComponentScan(basePackages={"com.web.spittr"},
        excludeFilters={
                @ComponentScan.Filter(type=FilterType.CUSTOM, value= RootConfig.WebPackage.class),
                @ComponentScan.Filter(type=FilterType.CUSTOM, value= RootConfig.SecurityPackage.class)
        })
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
    public static class SecurityPackage extends RegexPatternTypeFilter {
        public SecurityPackage() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
}