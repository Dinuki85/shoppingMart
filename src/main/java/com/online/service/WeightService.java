package com.online.service;

import com.online.model.WeightsCategory;
import com.online.model.WeightsItems;

import java.util.List;

public interface WeightService {

    //will handle weight category as well weight items
    public WeightsCategory createWeightCategory(String name,Long shopId)throws Exception;


    public WeightsCategory findWeightCategoryById(Long id)throws Exception;

    public List<WeightsCategory> findWeightCategoryByShopId(Long id ) throws Exception;

    public WeightsItems createWeightItem(Long shopId,String weightName,Long categoryId)throws Exception;


    public List<WeightsItems> findShopsWeights(Long ShopId);

    public WeightsItems updateStock(Long id) throws Exception;

}
