package com.zctech88.highlight_springmvc4;

import com.zctech88.highlight_springmvc4.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc//开启一些默认配置
@ComponentScan("com.zctech88.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * JSP 的 ViewResolver,用来映射路径
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new
                InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations
                ("classpath:/assets/");
    }
}
