package com.open.little;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.taiyuan.work.fitment.b2c.mapper")
@EnableAspectJAutoProxy
public class B2cBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(B2cBootstrap.class).run(args);    }
}
