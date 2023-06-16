package com.shinn.services.impl;

import com.shinn.dao.idao.ICartDAO;
import com.shinn.dao.impl.CartDAO;
import com.shinn.model.CartModel;
import com.shinn.services.IService.ICartService;

import java.util.List;

public class CartService implements ICartService {
    private ICartDAO cartDAO;
    public CartService() {
        cartDAO = new CartDAO();
    }


    @Override
    public List<CartModel> findByUserId(Long userId) {
        return cartDAO.findByUserId(userId);
    }

    @Override
    public List<CartModel> findAll() {
        return cartDAO.findAll();
    }

    @Override
    public Long insert(CartModel cartModel) {
        return cartDAO.insert(cartModel);
    }

    @Override
    public CartModel findByCartId(Long cartId) {
        return cartDAO.findByCartId(cartId);
    }
}
