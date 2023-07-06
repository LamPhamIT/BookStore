package com.shinn.services.impl;

import com.shinn.dao.idao.IOrderDAO;
import com.shinn.dao.idao.IOrderProductDAO;
import com.shinn.dao.impl.OrderDAO;
import com.shinn.dao.impl.OrderProductDAO;
import com.shinn.model.OrderModel;
import com.shinn.model.OrderProductModel;
import com.shinn.services.IService.IOrderService;

import java.sql.Timestamp;
import java.util.List;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;
    private IOrderProductDAO orderProductDAO;

    public OrderService() {
        orderDAO = new OrderDAO();
        orderProductDAO = new OrderProductDAO();
    }
    @Override
    public Long insert(OrderModel orderModel) {
        orderModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Long id = orderDAO.insert(orderModel);
        OrderModel order = new OrderModel();
        order.setId(id);
        for (OrderProductModel orderProductModel : orderModel.getListOrderProduct()) {
            orderProductModel.setOrder(order);
            orderProductDAO.insert(orderProductModel);
        }
        return id;
    }

    @Override
    public List<OrderModel> findByUserId(Long userId) {
        return orderDAO.findByUserId(userId);
    }
}
