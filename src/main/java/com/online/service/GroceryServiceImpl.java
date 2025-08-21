package com.online.service;

import com.online.model.Category;
import com.online.model.Grocery;
import com.online.model.Shop;
import com.online.repository.GroceryRepository;
import com.online.request.CreateGroceryRequests;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        List<Grocery> groceries = groceryRepository.findByShopId(shopId);

        if(isVegetarian){
            groceries=filteByVegetarian(groceries,isVegetarian);


        }
        if(isSeasonal){
            groceries = filterBySeasonal(groceries,isSeasonal);

        }

        if(isNonVeg){
            groceries=filterByNonVeg(groceries,isNonVeg);
        }

        if(groceryCategory!=null && !groceryCategory.equals("")){
            groceries= filterBYCategory(groceries,groceryCategory);
        }



        return groceries;
    }

    private List<Grocery> filterBYCategory(List<Grocery> groceries, String groceryCategory) {

        return groceries.stream().filter(grocery -> {
            if(grocery.getGroceryCategory()!=null){
                return grocery.getGroceryCategory().getName().equals(groceryCategory);
            }
            return false;
        }).collect(Collectors.toList());

    }

    private List<Grocery> filterByNonVeg(List<Grocery> groceries, boolean isNonVeg) {
        return groceries.stream().filter(grocery -> grocery.isVegetarian() == false).collect(Collectors.toList());


    }

    private List<Grocery> filterBySeasonal(List<Grocery> groceries, boolean isSeasonal) {

        return groceries.stream().filter(grocery -> grocery.isSeasonal() == isSeasonal ).collect(Collectors.toList());

    }

    private List<Grocery> filteByVegetarian(List<Grocery> groceries, boolean isVegetarian) {
    return groceries.stream().filter(grocery -> grocery.isVegetarian() == isVegetarian).collect(Collectors.toList());

    }

    @Override
    public List<Grocery> searchGrocery(String keyword) {

        return groceryRepository.searchGrocery(keyword);
    }

    @Override
    public Grocery findGroceryById(Long groceryId) throws Exception {
        Optional<Grocery> optionalGrocery = groceryRepository.findById(groceryId);

        if(optionalGrocery.isEmpty()){
            throw new Exception("This Grocery Item is not exists");
        }
        return optionalGrocery.get();
    }

    @Override
    public Grocery updateAvailabilityStatus(Long groceryId) throws Exception {
        return null;
    }
}
