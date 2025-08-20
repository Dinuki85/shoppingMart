package com.online.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeightsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name;

    @JsonIgnore
    @ManyToOne
    private Shop shop;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<WeightsItems> weights = new ArrayList<>();


}
