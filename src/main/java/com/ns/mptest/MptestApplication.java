package com.ns.mptest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ns.mptest.mapper")
@SpringBootApplication
public class MptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MptestApplication.class, args);
    }

}
