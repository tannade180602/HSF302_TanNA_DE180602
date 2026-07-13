package com.de180602.mvc.repository;

import com.de180602.mvc.entity.ShoesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesTypeRepository extends JpaRepository<ShoesType, String> {
}
