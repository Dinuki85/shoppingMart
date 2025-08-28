package com.online.service;

import com.online.model.Order;
import com.online.model.User;
import com.online.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception;

    public Order updateOrder(Long orderId,String orderStatus) throws Exception;

    public void cancelOrder(Long orderId) throws  Exception;

    public List<Order> getUserOrder(Long userId) throws Exception;

    public List<Order> getShopsOrder(Long shopId,String orderStatus)throws Exception;

    public Order findOrderById(Long orderId) throws Exception;

}
