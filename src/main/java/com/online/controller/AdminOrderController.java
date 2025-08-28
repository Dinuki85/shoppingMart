package com.online.controller;

import com.online.model.Order;
import com.online.model.User;
import com.online.request.OrderRequest;
import com.online.service.OrderService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;



    @GetMapping("/order/shop/{id}")
    public ResponseEntity<List<Order>> getOrderHistory(

            @PathVariable Long id,
            @RequestParam(required = false) String order_Status,
            @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);
        List<Order> order = orderService.getShopsOrder(id,order_Status);
        return  new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/order/{id}/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(

            @PathVariable Long id,
            @PathVariable String orderStatus,
            @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);
        Order order = orderService.updateOrder(id,orderStatus);
        return  new ResponseEntity<>(order, HttpStatus.OK);
    }

}
