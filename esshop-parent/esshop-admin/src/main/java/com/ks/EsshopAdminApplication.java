package com.ks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ks.dao")
public class EsshopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsshopAdminApplication.class, args);
    }

}
