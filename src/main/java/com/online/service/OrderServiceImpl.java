package com.online.service;

import com.online.model.*;
import com.online.repository.*;
import com.online.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopService shopService;

    @Autowired
    private CartService cartService;

    @Override
    public Order createOrder(OrderRequest order, User user) throws Exception {

        Address shippingAddress = order.getDeliveryAddress();

        Address saveAddress =addressRepository.save(shippingAddress);
        if(!user.getAddresses().contains(saveAddress)){
            user.getAddresses().add(saveAddress);
            userRepository.save(user);
        }

        Shop shop = shopService.findShopBYId(order.getShopId());

        Order createOrder = new Order();
        createOrder.setCustomer(user);
        createOrder.setCreatedAt(new Date());
        createOrder.setOrderStatus("PENDING");
        createOrder.setDeliveryAddress(saveAddress);
        createOrder.setShop(shop);

        Cart cart=cartService.findCartByUserId(user.getId());

        List<OrderItem> orderItems = new ArrayList<>();

        for(CartItem cartItem: cart.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setGrocery(cartItem.getGrocery());
            orderItem.setWeights(cartItem.getWeights());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(cartItem.getTotalPrice());

            OrderItem savedOrderItem = orderItemRepository.save(orderItem);

            orderItems.add(savedOrderItem);
        }

        Long totalPrice = cartService.calculateCartTotals(cart);
        createOrder.setItems(orderItems);
        createOrder.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(createOrder);
        shop.getOrders().add(savedOrder);
        return createOrder;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatus) throws Exception {


        return null;
    }

    @Override
    public void cancelOrder(Long orderId) throws Exception {

        Order order = findOrderById(orderId);
        orderRepository.deleteById(orderId);

    }

    @Override
    public List<Order> getUserOrder(Long userId) throws Exception {
        return List.of();
    }

    @Override
    public List<Order> getShopsOrder(Long shopId, String orderStatus) throws Exception {
        return List.of();
    }

    @Override
    public Order findOrderById(Long orderId) throws Exception {
        return null;
    }
}
