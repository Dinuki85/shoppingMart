package com.online.service;

import com.online.dto.ShopsDto;
import com.online.model.Address;
import com.online.model.Shop;
import com.online.model.User;
import com.online.repository.AddressRepository;
import com.online.repository.ShopRepository;
import com.online.request.CreateShopRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShopServiceImpl  implements ShopService{

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Autowired
    private UserService userService;


    //Method for creating a new shop and save it
    @Override
    public Shop createShop(CreateShopRequest req, User user) {
        Address address = addressRepository.save(req.getAddress());

        Shop shop = new Shop();
        shop.setAddress(address);
        shop.setContactInformation(req.getContactInformation());
        shop.setCuisineType(req.getCuisineType());
        shop.setDescription(req.getDescription());
        shop.setImages(req.getImages());
        shop.setName(req.getName());
        shop.setOpeningHours(req.getOpeningHours());
        shop.setRegistrationDate(LocalDateTime.now());
        shop.setOwner(user);


        return shopRepository.save(shop);
    }

    //Update the restaurant details
    @Override
    public Shop updateShop(Long shopId, CreateShopRequest updatedShop) throws Exception {
       Shop shop = findShopBYId(shopId);

       if(shop.getCuisineType()!=null)
       {
           shop.setCuisineType(updatedShop.getCuisineType());
       }

       if(shop.getDescription()!=null){
           shop.setDescription(updatedShop.getDescription());

       }

       if(shop.getName()!=null){
           shop.setName(updatedShop.getName());
       }
        if(shop.getAddress()!=null){
            shop.setAddress(updatedShop.getAddress());
        }
        if(shop.getContactInformation()!=null){
            shop.setContactInformation(updatedShop.getContactInformation());
        }
        if(shop.getOpeningHours()!=null){
            shop.setOpeningHours(updatedShop.getOpeningHours());
        }


        return shopRepository.save(shop);
    }

    @Override
    public void deleteShop(Long shopId) throws Exception {
        Shop shop = findShopBYId(shopId);

        shopRepository.delete(shop);

    }
    //Get all the shops
    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> searchShop(String keyword) {
        return shopRepository.findBySearchQUesry(keyword) ;
    }

    @Override
    public Shop findShopBYId(Long id) throws Exception {
        return null;
    }

    @Override
    public Shop getShopByUserId(Long UserId) throws Exception {
        return null;
    }

    @Override
    public ShopsDto addToFavourite(Long shopId, User user) throws Exception {
        return null;
    }

    @Override
    public Shop updateShopStatus(Long id) throws Exception {
        return null;
    }
}
