package com.web.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/12/4 09:13
 * @Description:
 */
@Configuration
@EnableWebMvc     // 启用mvc
@ComponentScan("com.web.spittr")  // 启用组件扫描
public class Webconfig extends WebMvcConfigurerAdapter {

    /**
     * 配置JSP视图解析器
     * @return
     */
/*    @Bean
    public ViewResolver viewResolver(){
        //
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/

    /**
     * thymeleaf 视图解析器  ThymeleafViewResolver 将逻辑视图名称解析为Thymeleaf模板视图；
     * @param templateEngine
     * @return
     */
    @Bean
    public ViewResolver viewResolver(
            SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    /**
     * 模板引擎 SpringTemplateEngine：处理模板并渲染结
     * @param templateResolver
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 模板解析器 TemplateResolver：加载Thymeleaf模
     * @return
     */
    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    /**
     * 静态文件处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

}















