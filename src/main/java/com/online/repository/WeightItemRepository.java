package com.online.repository;

import com.online.model.WeightsItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightItemRepository extends JpaRepository<WeightsItems ,Long> {


    List<WeightsItems> findByShopId(Long id);




}
