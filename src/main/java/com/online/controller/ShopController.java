package com.online.controller;

import com.online.dto.ShopsDto;
import com.online.model.Shop;
import com.online.model.User;
import com.online.request.CreateShopRequest;
import com.online.service.ShopService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;


    @GetMapping("/search")
    public ResponseEntity<List<Shop>> searchShop(@RequestParam String keyword, @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user =userService.findUserByJwtToken(jwt);

        List<Shop> shop = shopService.searchShop(keyword);

        return new ResponseEntity<>(shop, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Shop>> getAllShops(
            @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Shop> shop = shopService.getAllShops();
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Shop> findShopById(
            @PathVariable Long id,
            @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Shop shop = shopService.findShopBYId(id);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PutMapping("/addFavourite/{id}")
    public ResponseEntity<ShopsDto> addToFavourites(
            @PathVariable Long id,
            @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user =userService.findUserByJwtToken(jwt);

        ShopsDto shop = shopService.addToFavourite(id,user);



        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }



}
