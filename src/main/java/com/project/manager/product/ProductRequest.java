package com.project.manager.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequest {
    private String productName;
    private String productDesc;
    private Integer productPrice;
    private Integer productStock;
}

