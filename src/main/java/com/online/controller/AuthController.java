package com.online.controller;

import com.online.config.JwtProvider;
import com.online.model.Cart;
import com.online.model.User;
import com.online.repository.CartRepository;
import com.online.repository.UserRepository;
import com.online.response.AuthResponse;
import com.online.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private CartRepository cartRepository;


    //write method for the sign in
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception {

        User isEmailExists=userRepository.findByEmail(user.getEmail());
        //If the user not exists with the email
        if(isEmailExists!=null){
            throw new Exception("Email is already used with another account");

        }

        User createUser = new User();
        createUser.setEmail(user.getEmail());
        createUser.setFullName(user.getFullName());
        createUser.setRole(user.getRole());
        createUser.setPassword(user.getPassword());

        //To save the user
        User savedUser = userRepository.save(createUser);

        //Create the cart for the new user
        Cart cart = new Cart();
        cart.setCustomer(savedUser);
        cartRepository.save(cart);

        return null;
    }





}
