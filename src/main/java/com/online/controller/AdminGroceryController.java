package com.online.controller;

import com.online.model.Grocery;
import com.online.model.Shop;
import com.online.model.User;
import com.online.request.CreateGroceryRequests;
import com.online.response.MessageResponse;
import com.online.service.GroceryService;
import com.online.service.ShopService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/grocery")
public class AdminGroceryController {

    @Autowired
    private GroceryService groceryService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;


    @PostMapping("/create")
    public ResponseEntity<Grocery> createGrocery(@RequestBody CreateGroceryRequests req,
                                                @RequestHeader("Authorization") String jwt
                                                 ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Shop shop = shopService.findShopBYId(req.getShopId());

        Grocery grocery = groceryService.createGrocery(req,req.getCategory(),shop);
        return new ResponseEntity<>(grocery, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteGrocery(@PathVariable Long id,
                                                 @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        groceryService.deleteGrocery(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Grocery Item Deleted Successfully");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Grocery> updateGroceryAvailabilityStatus(@PathVariable Long id,
                                                         @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
       Grocery grocery = groceryService.updateAvailabilityStatus(id);


        return new ResponseEntity<>(grocery, HttpStatus.OK);
    }



}
