package com.shinn.services.impl;

import com.shinn.dao.idao.IOrderProductDAO;
import com.shinn.dao.impl.OrderProductDAO;
import com.shinn.model.OrderProductModel;
import com.shinn.services.IService.IOrderProductService;

import java.util.List;

public class OrderProductService implements IOrderProductService {
    private IOrderProductDAO orderProductDAO;
    public OrderProductService() {
        orderProductDAO = new OrderProductDAO();
    }
    @Override
    public List<OrderProductModel> findByOrderId(Long id) {
        return orderProductDAO.findByOrderId(id);
    }
}
