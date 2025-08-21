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
    public ResponseEntity<List<Grocery> > createGrocery(@RequestParam String name,
                                                 @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Grocery> groceries = groceryService.searchGrocery(name);
        return new ResponseEntity<>(groceries, HttpStatus.OK);

    }

}
