package com.online.controller;

import com.online.model.Shop;
import com.online.model.User;
import com.online.request.CreateShopRequest;
import com.online.response.MessageResponse;
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

    //Create a new shop
    @PostMapping("/create")
    public ResponseEntity<Shop> createShop(@RequestBody CreateShopRequest req, @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user =userService.findUserByJwtToken(jwt);

        Shop shop = shopService.createShop(req,user);

        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }
    //update the shop

    @PutMapping("/update/{id}")
    public ResponseEntity<Shop> updateShop(@RequestBody CreateShopRequest req, @RequestHeader("Authorization" ) String jwt,@PathVariable Long id) throws Exception {
        User user =userService.findUserByJwtToken(jwt);

        Shop shop = shopService.updateShop(id,req);

        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    //Delete the shop
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteShop(
            @RequestHeader("Authorization" ) String jwt,
            @PathVariable Long id) throws Exception {
        User user =userService.findUserByJwtToken(jwt);
        shopService.deleteShop(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Shop deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


       //Update Shop Status
    @PutMapping("/update/status/{id}")
    public ResponseEntity<Shop> updateShopStatus(
            @RequestHeader("Authorization" ) String jwt,
            @PathVariable Long id) throws Exception {
        User user =userService.findUserByJwtToken(jwt);
        Shop shop= shopService.updateShopStatus(id);

        return new ResponseEntity<>(shop, HttpStatus.OK);
    }


    //Find Shop By User id
    @GetMapping("/find/shop/user/{id}")
    public ResponseEntity<Shop> findShopByUserId(
            @RequestHeader("Authorization" ) String jwt) throws Exception {
        User user =userService.findUserByJwtToken(jwt);
        Shop shop= shopService.getShopByUserId(user.getId());

        return new ResponseEntity<>(shop, HttpStatus.OK);
    }


}
