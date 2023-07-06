package com.shinn.dao.idao;

import com.shinn.model.OrderModel;

import java.util.List;

public interface IOrderDAO{
    public Long insert(OrderModel orderModel);
    public List<OrderModel> findByUserId(Long userId);
}
