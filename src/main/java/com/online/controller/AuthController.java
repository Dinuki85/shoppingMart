package com.online.controller;

import com.online.config.JwtProvider;
import com.online.model.Cart;
import com.online.model.USER_ROLE;
import com.online.model.User;
import com.online.repository.CartRepository;
import com.online.repository.UserRepository;
import com.online.request.LoginRequest;
import com.online.response.AuthResponse;
import com.online.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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


    @PostMapping("/signup")
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
        createUser.setPassword(passwordEncoder.encode(user.getPassword()));

        //To save the user
        User savedUser = userRepository.save(createUser);

        //Create the cart for the new user
        Cart cart = new Cart();
        cart.setCustomer(savedUser);
        cartRepository.save(cart);


        //Created Authentication method

        //Generating Tokens
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        //Create auth response
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Successfully Registered");
        authResponse.setRole(savedUser.getRole());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);

    }


    @PostMapping("/signing")
    //create Login method

    public ResponseEntity<AuthResponse> signing(@RequestBody LoginRequest request){
        String username= request.getEmail();
        String password = request.getPassword();

        //if the username and password correct then authenticate it
        Authentication authentication = authenticate(username,password);

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String role = authorities.isEmpty()?null:authorities.iterator().next().getAuthority();


        //Generate the token

        String jwt = jwtProvider.generateToken(authentication);

        //Create auth response object
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Login Successful");
        authResponse.setRole(USER_ROLE.valueOf(role));

        return new ResponseEntity<>(authResponse, HttpStatus.OK);

    }

    private Authentication authenticate(String username, String password) {

        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
        if (userDetails==null){
            throw new BadCredentialsException("Invalid UserName");


        }



        //Check if the password is matches with our database or not
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
           throw new BadCredentialsException("Invalid Password");

        }


        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

    }


}
