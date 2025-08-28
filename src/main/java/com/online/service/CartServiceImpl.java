package com.online.service;

import com.online.model.Cart;
import com.online.model.CartItem;
import com.online.model.Grocery;
import com.online.model.User;
import com.online.repository.CartItemRepository;
import com.online.repository.CartRepository;
import com.online.repository.GroceryRepository;
import com.online.request.AddCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemRepository cartItemRepository;

    private GroceryService groceryService;

    @Override
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Grocery grocery = groceryService.findGroceryById(req.getGroceryId());

        Cart cart = cartRepository.findByCustomerId(user.getId());

        for(CartItem cartItem:cart.getItems()){
            if(cartItem.getGrocery().equals(grocery)){
                int newQuantity = cartItem.getQuantity()+req.getQuantity();
                return updateCartItemQuantity(cartItem.getId(),newQuantity);

            }
        }

        CartItem newCartItem = new CartItem();

        newCartItem.setGrocery(grocery);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(req.getQuantity());
        newCartItem.setWeights(req.getWeights());
        newCartItem.setTotalPrice(req.getQuantity()*grocery.getPrice());


        CartItem saved = cartItemRepository.save(newCartItem);

        cart.getItems().add(saved);


        return saved;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {




        return null;
    }

    @Override
    public Cart removeItemFromCart(Long CartItemId, String jwt) throws Exception {
        return null;
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {
        return 0L;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {
        return null;
    }

    @Override
    public Cart findCartByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public Cart clearCart(Long userId) throws Exception {
        return null;
    }
}
