package com.online.request;

import com.online.model.Category;
import com.online.model.WeightsItems;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroceryRequests {

    private String name;
    private String description;
    private Long price;

    private Category category;

    private List<String> images;

    private Long shopId;

    private boolean vegetarian;

    private boolean seasonal;
    private List<WeightsItems> weights;



}
