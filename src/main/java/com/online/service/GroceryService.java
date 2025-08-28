package com.online.service;

import com.online.model.Category;
import com.online.model.Grocery;
import com.online.model.Shop;
import com.online.request.CreateGroceryRequests;

import java.util.List;

public interface GroceryService {

    public Grocery createGrocery(CreateGroceryRequests req, Category category, Shop shop);

    public void deleteGrocery(Long groceryId) throws Exception;

    public List<Grocery> getShopGrocery(Long shopId, boolean isVegetarian, boolean isNonVeg, boolean isSeasonal, String groceryCategory);

    public List<Grocery> searchGrocery(String keyword);

    public Grocery findGroceryById(Long groceryId) throws Exception;

    public Grocery updateAvailabilityStatus(Long groceryId) throws Exception;


}


