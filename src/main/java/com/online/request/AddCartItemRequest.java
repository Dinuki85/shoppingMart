package com.online.request;

import lombok.Data;

import java.util.List;

@Data
public class AddCartItemRequest {

    private Long groceryId;
    private int quantity;
    private List<String> weights;
}
