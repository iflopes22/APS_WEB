package com.ads.webdesenv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdesenv.domain.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

}
