package com.web.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/12/3 21:49
 * @Description:   配置DispatcherServlet
 * AbstractAnnotationConfigDispatcherServletInitializer 用它来配置Servlet容器
 * 同时也就实现了WebApplicationInitializer，当部署到Servlet 3.0容器中的时候，
 *  容器会自动发现它， 并用它来配置Servlet上下文
 *  可以替代web.xml
 * extends AbstractAnnotationConfigDispatcherServletInitializer
 *
 */
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 附加性配置文件
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ RootConfig.class};
    }

    /**
     * 核心配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[ ]{ Webconfig.class };
    }

    /**
     * 它会将一个或多个路径映射到DispatcherServlet上
     *
     *  将DispatcherServlet映射到 "/" 这表示它会是应用的默认Servlet。 它会处理进入应用的所有请求。
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0));
    }
}
