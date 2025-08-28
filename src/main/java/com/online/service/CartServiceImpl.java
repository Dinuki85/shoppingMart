package com.online.service;

import com.online.model.Cart;
import com.online.model.CartItem;
import com.online.model.Grocery;
import com.online.model.User;
import com.online.repository.CartItemRepository;
import com.online.repository.CartRepository;
import com.online.request.AddCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()){
            throw new Exception("Cart Item Not Found");
        }
        CartItem item = cartItemOptional.get();
        item.setQuantity(quantity);


        item.setTotalPrice(item.getGrocery().getPrice()* quantity);

        return cartItemRepository.save(item);

    }

    @Override
    public Cart removeItemFromCart(Long CartItemId, String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Cart cart = cartRepository.findByCustomerId(user.getId());

        Optional<CartItem> cartItemOptional = cartItemRepository.findById(CartItemId);
        if(cartItemOptional.isEmpty()){
            throw new Exception("Cart Item Not Found");
        }

        CartItem cartItem = cartItemOptional.get();

        cart.getItems().remove(cartItem);

        return cartRepository.save(cart);
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {
        Long total = 0L;

        for(CartItem cartItem:cart.getItems()){
            total+=cartItem.getTotalPrice()*cartItem.getQuantity();
        }

        return total;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {
      Optional<Cart> optionalCart = cartRepository.findById(id);

      if(optionalCart.isEmpty()){
          throw new Exception(("Cart not found with id "+id));
      }


        return optionalCart.get();
    }

    @Override
    public Cart findCartByUserId(Long userId) throws Exception {
       // User user =userService.findUserByJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(userId);
        cart.setTotal(calculateCartTotals(cart));

        return cart;
    }

    @Override
    public Cart clearCart(Long userId) throws Exception {
      //  User user =userService.findUserByJwtToken(jwt);
        Cart cart = findCartByUserId(userId);

        cart.getItems().clear();
        return cartRepository.save(cart);
    }
}
