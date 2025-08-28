package com.online.repository;

import com.online.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroceryRepository extends JpaRepository<Grocery,Long> {

    List<Grocery> findByShopId(Long shopId);


    @Query("SELECT g FROM Grocery g WHERE g.name LIKE %?1% OR g.groceryCategory.name LIKE %?1% ")
    List<Grocery> searchGrocery(@Param("keyword" ) String keyword);
}
