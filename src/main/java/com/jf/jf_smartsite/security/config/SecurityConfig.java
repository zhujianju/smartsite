/*
package com.jf.jf_smartsite.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests()
                // 所有用户均可访问的资源
                //.antMatchers( "/login.html","/css/**","/plugins/**","/js/**","/img/**").permitAll()
                .antMatchers( "/**").permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.html").successForwardUrl("/admin/index.html").failureForwardUrl("/login.html")
                .and()
                .exceptionHandling().accessDeniedPage("/403");

                  http.logout().logoutSuccessUrl("/login");
    }

}
*/
