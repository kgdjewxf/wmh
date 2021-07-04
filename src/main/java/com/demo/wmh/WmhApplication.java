package com.demo.wmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.wmh.dao")
public class WmhApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmhApplication.class, args);
    }

}
