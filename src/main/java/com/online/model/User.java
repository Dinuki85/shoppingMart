package com.online.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.online.dto.ShopsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data//For the getter and setter methods
@AllArgsConstructor//For creating the constructors
@NoArgsConstructor
public class User {

    //Make this to tell This is the unique identifier of our entity
    @Id
    //Make the auto increment when user adding
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    //If the password is showing in the frontend it will be sensitive thing.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    //Whenever fetch the user list no need to fetch orders
    @JsonIgnore
    //One user Can Have Many orders
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

   //provides a streamlined way to map collections of basic types or embeddable objects directly within an entity.
    @ElementCollection
    private List<ShopsDto>favorites = new ArrayList();

    //When deleting the user from the database the users' address also will be deleted
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses  = new ArrayList<>();












}
