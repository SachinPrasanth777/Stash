package com.project.manager.product;

import lombok.Data;

@Data
public class ProductUpdate{
    private String productName;
    private String productDesc;
    private Integer productPrice;
    private Integer productStock;
}
