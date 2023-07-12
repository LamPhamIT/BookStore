package com.shinn.mapper;

import com.shinn.model.OrderProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProductMapper implements RowMapper<OrderProductModel> {
    @Override
    public OrderProductModel mapRow(ResultSet resultSet) {
        OrderProductModel orderProductModel = new OrderProductModel();
        try {
            orderProductModel.setNum(resultSet.getInt("Num"));
            try {
                ProductMapper productMapper = new ProductMapper();
                orderProductModel.setProduct(productMapper.mapRow(resultSet));
            } catch (Exception e) {

            }

        } catch (SQLException e) {

        }
        return orderProductModel;
    }
}
