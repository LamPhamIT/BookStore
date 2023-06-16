package com.shinn.dao.impl;

import com.shinn.dao.idao.ICartDAO;
import com.shinn.mapper.CartMapper;
import com.shinn.model.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO {
    @Override
    public List<CartModel> findByUserId(Long userId) {
        String sql = "SELECT * FROM Cart WHERE User_ID=?";
        return query(sql, new CartMapper(), userId);
    }

    @Override
    public Long insert(CartModel cartModel) {
        String sql = "INSERT INTO Cart(User_ID, Product_ID, Num) VALUES(?,?,?)";
        return insert(sql, cartModel.getUser().getId(), cartModel.getProduct().getId(), cartModel.getNum());
    }

    @Override
    public List<CartModel> findAll() {
        String sql = "SELECT * FROM Cart";
        return query(sql, new CartMapper());
    }

    @Override
    public CartModel findByCartId(Long cartId) {
        String sql = "SELECT * FROM Cart WHERE Cart_ID=?";
        List<CartModel> list = query(sql, new CartMapper(), cartId);
        return list.isEmpty() ? null : list.get(0);
    }
}
