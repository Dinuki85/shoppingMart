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

        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }
}
