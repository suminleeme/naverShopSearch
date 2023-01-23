/*
package com.example.navershopsearch.utils;

import com.example.navershopsearch.ItemDto;
import com.example.navershopsearch.Product;
import com.example.navershopsearch.ProductRepository;
import com.example.navershopsearch.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

// 매일 새벽 1시에 관심 상품 목록 제목으로 검색해서, 최저가 정보를 업데이트

@RequiredArgsConstructor // final 멤버 변수 자동 생성
@Component // 스프링이 필요 시 자동으로 생성하는 클래스 목록에 추가
public class Scheduler {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    // 초, 분, 시, 일, 월, 주 순서
    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        System.out.println("가격 업데이트 실행");

        // 저장된 모든 관심상품을 조회
        List<Product> productList = productRepository.findAll();

        for (int i=0; i<productList.size(); i++) {
            // 1초에 한 상품씩 조회 (naver 내 제한 규정)
            TimeUnit.SECONDS.sleep(1);

            // i번째 관심 상품을 꺼냄
            Product p = productList.get(i);

            // i번째 관심 상품의 제목으로 네이버 검색
            String title = p.getTitle();
            String resultString = naverShopSearch.search(title);

            // i번째 관심 상품의 검색 결과에서 첫번째 결과를 꺼냄  -> 이걸 최저가라고 가정하나??
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(resultString);
            ItemDto itemDto = itemDtoList.get(0);

            // i번째 관심 상품 정보를 업데이트
            Long id = p.getId();
            productService.updateBySearch(id, itemDto);
        }
    }

}
*/
