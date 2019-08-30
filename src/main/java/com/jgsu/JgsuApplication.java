package com.jgsu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.jgsu.dao")
public class JgsuApplication {
    public static void main(String[] args) {
        SpringApplication.run(JgsuApplication.class, args);
    }


}
