package com.online.repository;

import com.online.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {

    //Search for the shops
    @Query("SELECT s FROM Shop s WERE lower(s.name) LIKE lower(concat('&',:query,'%')) " +
            "OR lower(s.cuisineType) LIKE lower(concat('%',:query,'%'))  ")
    List<Shop> findBySearchQUesry(String query);

    Shop findByOwnerId(Long userId);



}
