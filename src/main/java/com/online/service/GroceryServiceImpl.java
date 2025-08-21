package com.online.service;

import com.online.model.Category;
import com.online.model.Grocery;
import com.online.model.Shop;
import com.online.repository.GroceryRepository;
import com.online.request.CreateGroceryRequests;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroceryServiceImpl implements GroceryService{

    @Autowired
    private GroceryRepository groceryRepository;



    //Method for create new Grocery
    @Override
    public Grocery createGrocery(CreateGroceryRequests req, Category category, Shop shop) {

        Grocery grocery = new Grocery();
        grocery.setGroceryCategory(category);
        grocery.setShop(shop);
        grocery.setDescription(req.getDescription());
        grocery.setImages(req.getImages());
        grocery.setName(req.getName());
        grocery.setWeights(req.getWeights());
        grocery.setSeasonal(req.isSeasonal());
        grocery.setVegetarian(req.isVegetarian());



        Grocery savedGrocery = groceryRepository.save(grocery);

        shop.getGroceries().add(savedGrocery);


        return savedGrocery;
    }

    @Override
    public void deleteFood(Long groceryId) throws Exception {

        Grocery grocery = findGroceryById(groceryId);
        grocery.setShop(null);
        groceryRepository.save(grocery);
    }

    @Override
    public List<Grocery> getShopGrocery(Long shopId, boolean isVegetarian, boolean isNonVeg, boolean isSeasonal, String groceryCategory) {
        return List.of();
    }

    @Override
    public List<Grocery> searchGrocery(String keyword) {
        return List.of();
    }

    @Override
    public Grocery findGroceryById(Long groceryId) throws Exception {
        return null;
    }

    @Override
    public Grocery updateAvailabilityStatus(Long groceryId) throws Exception {
        return null;
    }
}
