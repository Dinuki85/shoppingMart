package com.online.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name;

    private String description;

    private Long price;

    @ManyToOne
    private Category groceryCategory;

    @Column(length = 1000)
    //Create separate table for the images of the grocery items
    @ElementCollection
    private List<String> images;


    private boolean available;

    @ManyToOne
    private Shop shop;

    private boolean isVegetarian;

    private boolean isSeasonal;

    @ManyToMany
    private List<WeightsItems> weights = new ArrayList<>();


    private Date creationDate;



}
