package com.demo.pdsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.pdsys.dao")
public class PdsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdsysApplication.class, args);
    }

}
