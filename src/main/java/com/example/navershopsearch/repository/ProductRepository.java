package com.example.navershopsearch.repository;

import com.example.navershopsearch.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
