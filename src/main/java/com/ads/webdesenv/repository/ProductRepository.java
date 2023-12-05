package com.ads.webdesenv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdesenv.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
