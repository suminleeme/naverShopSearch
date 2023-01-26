package com.example.navershopsearch.springCorePrac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component // DI를 생성하기 위해 객체 생성이 되어야 하는데, 스프링 프레임워크가 @Component로 선언된 클래스를 객체로 만들어서 관리함('빈(Bean)' 객체)
public class ProductService {

    @Autowired // 이 멤버변수는 스프링에 의해 DI(외존성 주입) 됨
    private final ProductRepository productRepository;

    @Autowired // 이 함수가 사용하는 빈은 스프링에 의해 DI 됨
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);

        productRepository.createProduct(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productRepository.getProduct(id);

        if (product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }
        int myprice = requestDto.getMyprice();
        productRepository.updateMyprice(id, myprice);
        return product;
    }

    public List<Product> getProducts() throws SQLException {
        List<Product> products = productRepository.getAllProducts();

        return products;
    }
}
