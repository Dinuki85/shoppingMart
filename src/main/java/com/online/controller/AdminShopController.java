package com.online.controller;

import com.online.model.Shop;
import com.online.model.User;
import com.online.request.CreateShopRequest;
import com.online.service.ShopService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//All the endpoints that related to the owner of the shop
@RestController
@RequestMapping("/admin/shop")
public class AdminShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Shop> createShop(@RequestBody CreateShopRequest req, @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user =userService.findUserByJwtToken(jwt);

        Shop shop = shopService.createShop(req,user);

        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Shop> updateShop(@RequestBody CreateShopRequest req, @RequestHeader("Authorization" ) String jwt,@PathVariable Long id) throws Exception {
        User user =userService.findUserByJwtToken(jwt);

        Shop shop = shopService.updateShop(id,req);

        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }




}
