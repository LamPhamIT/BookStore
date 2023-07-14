package com.shinn.dao.impl;

import com.shinn.dao.idao.IOrderDAO;
import com.shinn.mapper.OrderMapper;
import com.shinn.model.OrderModel;

import java.util.List;

public class OrderDAO extends AbstractDAO<OrderDAO> implements IOrderDAO {
    @Override
    public Long insert(OrderModel orderModel) {
        if (orderModel.getUser() == null) {
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

    @Override
    public OrderModel findByOrderId(Long id) {
        String sql = "SELECT * FROM Order_Detail AS o INNER JOIN Order_Status AS s ON o.Status_ID=s.Status_ID WHERE Order_ID=?";
        List<OrderModel> list = query(sql, new OrderMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int countBoughtOrder() {
        String sql = "SELECT COUNT(*) FROM Order_Detail WHERE Status_ID=3";
        return count(sql);
    }

    @Override
    public int countOrderUnconfirm() {
        String sql = "SELECT COUNT(*) FROM Order_Detail WHERE Status_ID=1";
        return count(sql);
    }

    @Override
    public List<OrderModel> findAll() {
        String sql = "SELECT * FROM Order_Detail AS o INNER JOIN Order_Status AS s ON o.Status_ID=s.Status_ID";
        return query(sql, new OrderMapper());
    }

    @Override
    public List<OrderModel> findByStatusId(Long statusId) {
        String sql = "";
        if (statusId == 0) {
            sql = "SELECT * FROM Order_Detail AS o INNER JOIN Order_Status AS s ON o.Status_ID=s.Status_ID";
            return query(sql, new OrderMapper());
        }
        sql = "SELECT * FROM Order_Detail AS o INNER JOIN Order_Status AS s ON o.Status_ID=s.Status_ID WHERE s.Status_ID=?";

        return query(sql, new OrderMapper(), statusId);
    }

    @Override
    public void updateStatus(Long orderId, Long statusId) {
        String sql = "UPDATE Order_Detail SET Status_ID=? WHERE Order_ID=?";
        update(sql, statusId, orderId);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Order_Detail WHERE Order_ID=?";
        update(sql, id);
    }
}
