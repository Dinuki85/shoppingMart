package com.online.service;

import com.online.dto.ShopsDto;
import com.online.model.Address;
import com.online.model.Shop;
import com.online.model.User;
import com.online.repository.AddressRepository;
import com.online.repository.ShopRepository;
import com.online.repository.UserRepository;
import com.online.request.CreateShopRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl  implements ShopService{

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Autowired
    private UserRepository userRepository;


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

    //Search shop
    @Override
    public List<Shop> searchShop(String keyword) {
        return shopRepository.findBySearchQuery(keyword) ;
    }

    //Find the shop by shop id
    @Override
    public Shop findShopBYId(Long id) throws Exception {
        Optional<Shop> opt = shopRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("Shop Not Found with id : "+id);
        }

        return opt.get();
    }

    @Override
    public Shop getShopByUserId(Long userId) throws Exception {
      Shop shop = shopRepository.findByOwnerId(userId);

      if(shop == null){
          throw new Exception("Shop Not Found with owner id : "+userId);
      }

        return shop;
    }

    @Override
    public ShopsDto addToFavourite(Long shopId, User user) throws Exception {

        //First search for the shop by id
        Shop  shop =findShopBYId(shopId);

        ShopsDto dto = new ShopsDto();
        dto.setDescription(shop.getDescription());
        dto.setImages(shop.getImages());
        dto.setTitle(shop.getName());

        dto.setId(shopId);

        //take one variable and default it will be false
       boolean isFavourited = false;

       //get a loop through all the shops
       List<ShopsDto> favorites = user.getFavorites();
       for(ShopsDto favorite : favorites){
           //If any of the user id is match with the id which are provided by the frontend
           if(favorite.getId().equals(shopId)){
               isFavourited = true;
               break;
           }
       }
       //If the SHop is already favourite ,remove it:otherwise,add it to favorites
        //Remove all the shops which are included the same idm
        if(isFavourited){
            favorites.removeIf(favorite -> favorite.getId().equals(shopId));
        }else {
            favorites.add(dto);
        }
        userRepository.save(user);
        return dto;
    }

    @Override
    public Shop updateShopStatus(Long id) throws Exception {
        //First search for the shop by id
        Shop  shop =findShopBYId(id);

        shop.setOpen(!shop.isOpen());


        return shopRepository.save(shop);
    }
}
