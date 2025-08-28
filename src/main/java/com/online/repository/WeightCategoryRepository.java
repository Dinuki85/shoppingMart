package com.online.repository;

import com.online.model.WeightsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightCategoryRepository extends JpaRepository<WeightsCategory,Long> {
}
