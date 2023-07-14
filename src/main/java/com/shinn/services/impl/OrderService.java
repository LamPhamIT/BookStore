package com.shinn.services.impl;

import com.shinn.dao.idao.IOrderDAO;
import com.shinn.dao.idao.IOrderProductDAO;
import com.shinn.dao.idao.IProductDAO;
import com.shinn.dao.impl.OrderDAO;
import com.shinn.dao.impl.OrderProductDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.OrderModel;
import com.shinn.model.OrderProductModel;
import com.shinn.model.ProductModel;
import com.shinn.services.IService.IOrderService;

import java.sql.Timestamp;
import java.util.List;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;
    private IOrderProductDAO orderProductDAO;
    private IProductDAO productDAO;

    public OrderService() {
        productDAO = new ProductDAO();
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
            ProductModel product = productDAO.findOne(orderProductModel.getProduct().getId());
            product.setRemainQuality(product.getRemainQuality() - orderProductModel.getNum());
            productDAO.updateNum(product.getId(), product.getRemainQuality());
            orderProductDAO.insert(orderProductModel);
        }
        return id;
    }

    @Override
    public List<OrderModel> findByUserId(Long userId) {
        return orderDAO.findByUserId(userId);
    }

    @Override
    public OrderModel findByOrderId(Long orderId) {
        OrderModel orderModel = orderDAO.findByOrderId(orderId);
        orderModel.setListResult(orderProductDAO.findByOrderId(orderModel.getId()));
        return orderModel;
    }

    @Override
    public int countOrdered() {
        return orderDAO.countBoughtOrder();
    }

    @Override
    public int countUnconfirmed() {
        return orderDAO.countOrderUnconfirm();

    }

    @Override
    public List<OrderModel> findAll() {
        return orderDAO.findAll();

    }

    @Override
    public List<OrderModel> findByStatusId(Long id) {
        return orderDAO.findByStatusId(id);
    }

    @Override
    public void updateStatus(Long orderId, Long statusId) {
        orderDAO.updateStatus(orderId, statusId);
    }

    @Override
    public void delete(OrderModel orderModel) {
        for(Long id : orderModel.getIds()) {
            orderDAO.delete(id);
        }
    }
}
