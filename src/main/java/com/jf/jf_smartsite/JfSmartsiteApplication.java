package com.jf.jf_smartsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jf.jf_smartsite.*.mapper")
public class JfSmartsiteApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JfSmartsiteApplication.class, args);
    }

    /*protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JfSmartsiteApplication.class);
    }*/
}
