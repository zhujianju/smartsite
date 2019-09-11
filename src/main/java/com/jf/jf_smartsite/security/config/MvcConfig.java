package com.jf.jf_smartsite.security.config;

import com.jf.jf_smartsite.security.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 欧Sir on 2019/8/31.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 通过@Bean注解，将我们定义的拦截器注册到Spring容器
     * @return
     */
    @Bean
    public MyInterceptor loginInterceptor(){
        return new MyInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/login.html","/css/*","/js/**","/img/**","plugins/**","/login/**","/");
    }
}
