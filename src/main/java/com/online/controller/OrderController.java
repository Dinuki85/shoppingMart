package com.online.controller;

import com.online.model.CartItem;
import com.online.model.Order;
import com.online.model.User;
import com.online.request.AddCartItemRequest;
import com.online.request.OrderRequest;
import com.online.service.OrderService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,

                                          @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);
         Order order = orderService.createOrder(req,user);
        return  new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
