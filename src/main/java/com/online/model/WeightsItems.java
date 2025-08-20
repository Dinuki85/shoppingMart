package com.online.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightsItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name;



    @ManyToOne
    private WeightsCategory category;

    @JsonIgnore
    @ManyToOne
    private Shop shop;

    private boolean isStock = true;


}
