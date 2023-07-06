package com.shinn.mapper;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import com.shinn.model.OrderModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet resultSet) {
        OrderModel orderModel = new OrderModel();
        try {

            orderModel.setId(resultSet.getLong("Order_ID"));
            orderModel.setFullname(resultSet.getString("Fullname"));
            orderModel.setEmail(resultSet.getString("Email"));
            orderModel.setPhoneNumber(resultSet.getString("PhoneNumber"));
            orderModel.setAddress(resultSet.getString("Address"));
            orderModel.setNote(resultSet.getString("Note"));
            orderModel.setShippingFee(resultSet.getLong("ShippingFee"));
            orderModel.setPrice(resultSet.getLong("Price"));
            orderModel.setCreatedDate(resultSet.getTimestamp("CreatedDate"));
            try {
                OrderStatusMapper orderStatusMapper = new OrderStatusMapper();


                orderModel.setOrderStatus(orderStatusMapper.mapRow(resultSet));
            } catch (Exception e) {

            }
            try {

            } catch(Exception e) {
                UserMapper userMapper = new UserMapper();
                orderModel.setUser(userMapper.mapRow(resultSet));
            }
            return orderModel;
        } catch (SQLException e) {

        }
        return null;
    }
}
