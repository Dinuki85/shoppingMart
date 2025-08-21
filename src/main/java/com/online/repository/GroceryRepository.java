package com.online.repository;

import com.online.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroceryRepository extends JpaRepository<Grocery,Long> {

    List<Grocery> findByShopId(Long shopId);


    @Query("SELECT g FROM Grocery g WHERE f.name LIKE %:keyword:% OR f.groceryCategory.name LIKE %:keyword ")
    List<Grocery> searchGrocery(@Param("keyword" ) String keyword);
}
