package com.shinn.mapper;

import com.shinn.model.OrderStatusModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStatusMapper implements RowMapper<OrderStatusModel>{
    @Override
    public OrderStatusModel mapRow(ResultSet resultSet) {
        OrderStatusModel orderStatusModel = new OrderStatusModel();
        try {
            orderStatusModel.setId(resultSet.getLong("Status_ID"));
            orderStatusModel.setName(resultSet.getString("Name"));
            return orderStatusModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
