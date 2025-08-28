package com.online.controller;

import com.online.model.CartItem;
import com.online.request.AddCartItemRequest;
import com.online.request.UpdateCartItemRequest;
import com.online.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PutMapping("/cart/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws Exception{
    CartItem cartItem = cartService.addItemToCart(req,jwt);
    return  new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }
    @PutMapping("/cartItem/update")
    public ResponseEntity<CartItem> updateCartItemQuantity(
            @RequestBody UpdateCartItemRequest req,
           @RequestHeader("Authorization") String jwt) throws Exception{
        CartItem cartItem = cartService.updateCartItemQuantity(req.getCartItemId(),req.getQuantity());
        return  new ResponseEntity<>(cartItem, HttpStatus.OK);
    }
}
