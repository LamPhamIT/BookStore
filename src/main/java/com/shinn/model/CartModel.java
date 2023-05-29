package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CartModel extends AbstractModel{
    private UserModel user;
    private ProductModel product;

}
