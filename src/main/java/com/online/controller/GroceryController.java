package com.online.controller;

import com.online.model.Grocery;
import com.online.model.Shop;
import com.online.model.User;
import com.online.request.CreateGroceryRequests;
import com.online.service.GroceryService;
import com.online.service.ShopService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
    @Autowired
    private GroceryService groceryService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;


    @GetMapping("/search")
    public ResponseEntity<List<Grocery> > searchGrocery(@RequestParam String name,
                                                 @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Grocery> groceries = groceryService.searchGrocery(name);
        return new ResponseEntity<>(groceries, HttpStatus.OK);

    }


    @PostMapping("/shop/{shopId}")
    public ResponseEntity<List<Grocery>> getShopGrocery(
            @RequestParam boolean vegetarian,
            @RequestParam boolean nonveg,
            @RequestParam boolean sesonal,
            @RequestParam(required = false) String grocery_category,
            @PathVariable Long shopId,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Grocery> groceries = groceryService.getShopGrocery(shopId,vegetarian,nonveg,sesonal,grocery_category);
        return new ResponseEntity<>(groceries, HttpStatus.OK);

    }


}
