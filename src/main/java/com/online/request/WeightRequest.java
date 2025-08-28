package com.online.request;

import lombok.Data;

@Data
public class WeightRequest {
    private String name;
    private Long categoryId;
    private Long shopId;
}
