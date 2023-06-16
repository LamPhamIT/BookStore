package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartModel extends AbstractModel{
    private UserModel user;
    private ProductModel product;
    private int num;
}
