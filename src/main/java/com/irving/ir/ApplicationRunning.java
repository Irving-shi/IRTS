package com.irving.ir;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author irving
 * @date 2021/6/10
 */
@SpringBootApplication
@MapperScan(value = "com.irving.ir.mapper")
public class ApplicationRunning {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunning.class,args);
    }

}
