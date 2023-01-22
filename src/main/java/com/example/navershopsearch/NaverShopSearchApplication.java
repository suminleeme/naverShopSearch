package com.example.navershopsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 시간 자동 변경이 가능하도록 함
@SpringBootApplication
public class NaverShopSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaverShopSearchApplication.class, args);
    }

}
