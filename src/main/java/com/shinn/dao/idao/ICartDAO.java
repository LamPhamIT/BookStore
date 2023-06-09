package com.shinn.dao.idao;

import com.shinn.model.CartModel;

import java.util.List;

public interface ICartDAO {
    public List<CartModel> findByUserId(Long userId);
    public Long insert(CartModel cartModel);
    public List<CartModel> findAll();
    public CartModel findByCartId(Long cartId);
    public void update(CartModel cartModel);
    public void delete(Long cartId);
    public void deleteByUserID(Long userId);
}
