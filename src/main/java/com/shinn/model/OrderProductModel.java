package com.shinn.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProductModel {
    private OrderModel order;
    private ProductModel product;
    private int num;
}
