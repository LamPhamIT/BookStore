package com.shinn.services.IService;

import com.shinn.model.OrderProductModel;

import java.util.List;

public interface IOrderProductService {
    public List<OrderProductModel> findByOrderId(Long id);
}
