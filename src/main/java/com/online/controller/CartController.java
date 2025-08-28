package com.online.controller;

import com.online.model.Cart;
import com.online.model.CartItem;
import com.online.model.User;
import com.online.request.AddCartItemRequest;
import com.online.request.UpdateCartItemRequest;
import com.online.service.CartService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;


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

    @DeleteMapping("/cartItem/{id}/remove")
    public ResponseEntity<Cart> removeCartItem(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception{
        Cart cart = cartService.removeItemFromCart(id,jwt);
        return  new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearCart(

            @RequestHeader("Authorization") String jwt) throws Exception{
      User user =userService.findUserByJwtToken(jwt);
        Cart cart = cartService.clearCart(user.getId());
        return  new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> findUserCart(

            @RequestHeader("Authorization") String jwt) throws Exception{
        User user =userService.findUserByJwtToken(jwt);

        Cart cart = cartService.findCartByUserId(user.getId());
        return  new ResponseEntity<>(cart, HttpStatus.OK);
    }


}
