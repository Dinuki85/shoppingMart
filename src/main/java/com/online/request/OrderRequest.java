package com.online.request;

import com.online.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long shopId;
    private Address deliveryAddress;
}
