package com.shinn.dao.idao;

import com.shinn.model.OrderProductModel;

import java.util.List;

public interface IOrderProductDAO {
    public Long insert(OrderProductModel orderProductModel);
    public List<OrderProductModel> findByOrderId(Long id);
}
