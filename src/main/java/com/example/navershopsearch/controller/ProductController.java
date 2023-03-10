package com.example.navershopsearch.controller;

import com.example.navershopsearch.model.Product;
import com.example.navershopsearch.dto.ProductMypriceRequestDto;
import com.example.navershopsearch.dto.ProductRequestDto;
import com.example.navershopsearch.security.UserDetailsImpl;
import com.example.navershopsearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {

    private final ProductService productService;

/* -> @RequiredArgsConstructor 가 대신 생성, 생략
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
*/

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {

        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = productService.createProduct(requestDto);

        // 응답 보내기
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {

        Product product = productService.updateProduct(id, requestDto);

        // 응답 보내기 (업데이트된 상품 id)
        return product.getId();
    }

/*    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {

        List<Product> products = productService.getProducts();

        // 응답 보내기
        return products;
    }*/

    // 로그인한 회원이 등록한 관심 상품 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 회원 테이블의 ID
        Long userId = userDetails.getUser().getId();

        return productService.getProducts(userId);
    }
}