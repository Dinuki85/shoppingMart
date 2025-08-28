package com.online.repository;

import com.online.model.WeightsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightCategoryRepository extends JpaRepository<WeightsCategory,Long> {

    List<WeightsCategory> findByShopId(Long id);


}
