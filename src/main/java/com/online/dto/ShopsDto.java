package com.online.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
//used to define a class whose properties can be embedded within another entity class, rather than creating a separate table for it.
@Embeddable

public class ShopsDto {
    private String title;

    //specify the maximum length for a database column that maps to a field in an entity.
    @Column(length = 1000)
    private List<String> images;

    private String description;

    private Long id;




}
