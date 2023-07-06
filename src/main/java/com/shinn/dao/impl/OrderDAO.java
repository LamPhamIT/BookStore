package com.shinn.dao.impl;

import com.shinn.dao.idao.IOrderDAO;
import com.shinn.mapper.OrderMapper;
import com.shinn.model.OrderModel;

import java.util.List;

public class OrderDAO extends AbstractDAO<OrderDAO> implements IOrderDAO {
    @Override
    public Long insert(OrderModel orderModel) {
      if(orderModel.getUser() == null) {
          String sql = "INSERT INTO Order_Detail(Fullname, Email, PhoneNumber, Address, Note, ShippingFee, Price, Status_ID, CreatedDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
          return insert(sql, orderModel.getFullname(), orderModel.getEmail(), orderModel.getPhoneNumber(), orderModel.getAddress(),
                  orderModel.getNote(), orderModel.getShippingFee(), orderModel.getPrice(), 1L, orderModel.getCreatedDate());
      } else {
          String sql = "INSERT INTO Order_Detail(Fullname, Email, PhoneNumber, Address, Note, ShippingFee, Price, Status_ID, User_ID, CreatedDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          return insert(sql, orderModel.getFullname(), orderModel.getEmail(), orderModel.getPhoneNumber(), orderModel.getAddress(),
                  orderModel.getNote(), orderModel.getShippingFee(), orderModel.getPrice(), 1L, orderModel.getUser().getId(), orderModel.getCreatedDate());
      }

    }

    @Override
    public List<OrderModel> findByUserId(Long userId) {
        String sql = "SELECT * FROM Order_Detail AS o INNER JOIN Order_Status AS s ON o.Status_ID=s.Status_ID WHERE User_ID=?";
        return query(sql, new OrderMapper(), userId);
    }
}
