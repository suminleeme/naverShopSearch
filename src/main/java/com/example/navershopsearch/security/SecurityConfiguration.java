package com.example.navershopsearch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> {
                            try {
                                authz
                                        .antMatchers("/images/**").permitAll()
                                        .antMatchers("/css/**").permitAll()
                                        .anyRequest().authenticated()
                                        .and()
                                            .formLogin()
                                            .loginPage("/user/login")
                                            .defaultSuccessUrl("/")
                                            .failureUrl("/user/login?error")
                                            .permitAll()
                                        .and()
                                            .logout()
                                            .permitAll();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .httpBasic(withDefaults());
        return http.build();
    }
}
