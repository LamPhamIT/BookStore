package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailModel extends AbstractModel{
    private OrderModel order;
    private ProductModel product;
    private int num;
    private Long totalMoney;

}
