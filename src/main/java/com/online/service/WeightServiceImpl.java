package com.online.service;

import com.online.model.Shop;
import com.online.model.WeightsCategory;
import com.online.model.WeightsItems;
import com.online.repository.WeightCategoryRepository;
import com.online.repository.WeightItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeightServiceImpl implements WeightService{

    @Autowired
    private WeightItemRepository weightItemRepository;

    @Autowired
    private WeightCategoryRepository weightCategoryRepository;


    @Autowired
    private ShopService shopService;

    @Override
    public WeightsCategory createWeightCategory(String name, Long shopId) throws Exception {

        Shop shop = shopService.findShopBYId(shopId);

        WeightsCategory category=new WeightsCategory();
        category.setShop(shop);
        category.setName(name);

        return weightCategoryRepository.save(category);
    }

    @Override
    public WeightsCategory findWeightCategoryById(Long id) throws Exception {
       Optional<WeightsCategory> opt = weightCategoryRepository.findById(id);

       if(opt.isEmpty()){
           throw new Exception("Weight category Not Found");
       }
        return opt.get();
    }

    @Override
    public List<WeightsCategory> findWeightCategoryByShopId(Long id) throws Exception {

        shopService.findShopBYId(id);
        return weightCategoryRepository.findByShopId(id);
    }

    @Override
    public WeightsItems createWeightItem(Long shopId, String weightName, Long categoryId) throws Exception {
        Shop shop = shopService.findShopBYId(shopId);
       WeightsCategory category = findWeightCategoryById(shopId);

        WeightsItems item = new WeightsItems();
        item.setName(weightName);
        item.setShop(shop);
        item.setCategory(category);

        WeightsItems weight = weightItemRepository.save(item);

        category.getWeights().add(weight);

        return weight;
    }

    @Override
    public List<WeightsItems> findShopsWeights(Long ShopId) {

        return weightItemRepository.findByShopId(ShopId);
    }

    @Override
    public WeightsItems updateStock(Long id) throws Exception {
        return null;
    }
}
