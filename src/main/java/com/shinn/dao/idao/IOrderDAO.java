package com.shinn.dao.idao;

import com.shinn.model.OrderModel;

import java.util.List;

public interface IOrderDAO{
    public Long insert(OrderModel orderModel);
    public List<OrderModel> findByUserId(Long userId);
    public OrderModel findByOrderId(Long id);
    public int countBoughtOrder();
    public int countOrderUnconfirm();
    public List<OrderModel> findAll();
    public List<OrderModel> findByStatusId(Long statusId);
    public void updateStatus(Long orderId, Long statusId);
    public void delete(Long id);
}
