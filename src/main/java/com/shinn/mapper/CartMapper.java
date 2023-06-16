package com.shinn.mapper;

import com.shinn.model.CartModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<CartModel> {
    @Override
    public CartModel mapRow(ResultSet resultSet) {
        CartModel cartModel = new CartModel();
        try {
            cartModel.setId(resultSet.getLong("Cart_ID"));
            cartModel.setNum(resultSet.getInt("Num"));
            try {
                UserMapper userMapper = new UserMapper();
                cartModel.setUser(userMapper.mapRow(resultSet));
                ProductMapper productMapper = new ProductMapper();
                cartModel.setProduct(productMapper.mapRow(resultSet));
            }catch (Exception e) {
                e.printStackTrace();
            }
            return cartModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
