package com.example.navershopsearch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity // Spring Security 지원을 가능하게 함
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .ignoringAntMatchers("/user/**");

        http.authorizeRequests()
                // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
                // 회원 관리 처리 API 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()
                // 그 외 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()
                // 로그인 기능
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .failureUrl("/user/login?error")
                .permitAll()
                .and()
                // 로그아웃 기능
                .logout()
                .permitAll();
        return http.build();
    }
}
