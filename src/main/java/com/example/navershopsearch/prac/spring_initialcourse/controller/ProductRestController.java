/*
package com.example.navershopsearch;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 관심 상품 관련 컨트롤러
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성
@RestController // JSON으로 데이터를 주고받음을 선언
public class ProductRestController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/product/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMyPriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }
}
*/
