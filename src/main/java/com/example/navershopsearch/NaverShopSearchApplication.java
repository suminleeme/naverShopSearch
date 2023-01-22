package com.example.navershopsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 스프링 부트에서 스케줄러가 작동하게 함
@EnableJpaAuditing // 시간 자동 변경이 가능하도록 함
@SpringBootApplication
public class NaverShopSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaverShopSearchApplication.class, args);
    }

}
