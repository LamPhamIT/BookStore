package com.shinn.services.IService;

import com.shinn.model.OrderModel;

import java.util.List;

public interface IOrderService {
    public Long insert(OrderModel orderModel);
    public List<OrderModel> findByUserId(Long userId);
    public OrderModel findByOrderId(Long orderId);
    public int countOrdered();
    public int countUnconfirmed();

}
