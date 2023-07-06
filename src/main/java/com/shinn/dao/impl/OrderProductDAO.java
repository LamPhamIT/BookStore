package com.shinn.dao.impl;

import com.shinn.dao.idao.IOrderProductDAO;
import com.shinn.model.OrderProductModel;

public class OrderProductDAO extends AbstractDAO<OrderProductModel> implements IOrderProductDAO {

    @Override
    public Long insert(OrderProductModel orderProductModel) {
        String sql = "INSERT INTO Order_Product(Order_Id, Product_ID, Num) VALUES(?,?,?)";
        return insert(sql, orderProductModel.getOrder().getId(), orderProductModel.getProduct().getId(), orderProductModel.getNum());
    }
}
