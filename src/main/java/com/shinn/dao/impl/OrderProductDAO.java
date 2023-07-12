package com.shinn.dao.impl;

import com.shinn.dao.idao.IOrderProductDAO;
import com.shinn.mapper.OrderProductMapper;
import com.shinn.model.OrderProductModel;

import java.util.List;

public class OrderProductDAO extends AbstractDAO<OrderProductModel> implements IOrderProductDAO {

    @Override
    public Long insert(OrderProductModel orderProductModel) {
        String sql = "INSERT INTO Order_Product(Order_Id, Product_ID, Num) VALUES(?,?,?)";
        return insert(sql, orderProductModel.getOrder().getId(), orderProductModel.getProduct().getId(), orderProductModel.getNum());
    }

    @Override
    public List<OrderProductModel> findByOrderId(Long id) {
        String sql = "SELECT * FROM Order_Product As o INNER JOIN Product AS p ON o.Product_ID=p.Product_ID WHERE Order_ID=?";
        return query(sql, new OrderProductMapper(), id);
    }
}
