package com.online.service;

import com.online.dto.ShopsDto;
import com.online.model.Shop;
import com.online.model.User;
import com.online.request.CreateShopRequest;

import java.util.List;

public interface ShopService {
    public Shop createShop(CreateShopRequest req, User user);

    public Shop updateShop(Long shopId,CreateShopRequest updatedShop) throws Exception;

    public void deleteShop(Long shopId)throws Exception;

    public List<Shop> getAllShops();

    public List<Shop> searchShop(String keyword);

    public Shop findShopBYId(Long id) throws Exception;

    public Shop getShopByUserId(Long userId)throws Exception;

    public ShopsDto addToFavourite(Long shopId,User user)throws Exception;

    public Shop updateShopStatus(Long id) throws Exception;
}
