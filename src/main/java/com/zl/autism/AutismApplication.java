package com.zl.autism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.zl.autism.mapper")
@SpringBootApplication(scanBasePackages = "com.zl.autism")
public class AutismApplication{

    public static void main(String[] args) {
        SpringApplication.run(AutismApplication.class, args);
    }

}
