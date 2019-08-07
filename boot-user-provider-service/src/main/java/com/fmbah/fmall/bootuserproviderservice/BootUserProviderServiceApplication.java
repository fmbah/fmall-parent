package com.fmbah.fmall.bootuserproviderservice;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class BootUserProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserProviderServiceApplication.class, args);
    }

}
