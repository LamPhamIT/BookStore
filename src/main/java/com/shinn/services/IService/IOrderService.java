package com.shinn.services.IService;

import com.shinn.model.OrderModel;

import java.util.List;

public interface IOrderService {
    public Long insert(OrderModel orderModel);
    public List<OrderModel> findByUserId(Long userId);

}
