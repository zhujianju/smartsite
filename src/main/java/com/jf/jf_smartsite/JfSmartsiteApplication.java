package com.jf.jf_smartsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jf.jf_smartsite.*.mapper")
public class JfSmartsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfSmartsiteApplication.class, args);
    }

}
