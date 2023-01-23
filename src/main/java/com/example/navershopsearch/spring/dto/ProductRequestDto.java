package com.example.navershopsearch.spring.dto;

import lombok.Getter;

// 관심 상품 등록하기
@Getter
public class ProductRequestDto {
    private String title;
    private String link;
    private String image;
    private int lprice;
}
