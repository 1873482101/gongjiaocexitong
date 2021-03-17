package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

//手动注入dao层(数据库连接)//正常为@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//手动添加数据库代码包位置正常自动查找不需要此语句
//@ComponentScan(basePackages = "com.example.demo.mapper.*")

@SpringBootApplication()
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
