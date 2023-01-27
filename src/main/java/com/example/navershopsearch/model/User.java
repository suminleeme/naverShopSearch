package com.example.navershopsearch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor // 기본 생성자를 만들어줌
@Entity // db 테이블 역할
@Table(name="CUSTOM_USER")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO) // ID가 자동으로 생성 및 증가
    @Id
    private Long id;

    @Column(nullable = false, unique = true) // null 허용 X, 중복 비허용
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(String username, String password, String email, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

}
