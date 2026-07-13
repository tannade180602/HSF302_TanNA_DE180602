package com.de180602.mvc.repository;

import com.de180602.mvc.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Integer> {
    List<Shoes> findAllByOrderByShoesNameAsc();
    List<Shoes> findByShoesNameContainingIgnoreCaseOrderByShoesNameAsc(String name);
}
