package com.ads.webdesenv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdesenv.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	//List<cart> findAllById(Long id);

}
