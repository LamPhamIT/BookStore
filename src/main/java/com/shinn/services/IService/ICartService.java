package com.shinn.services.IService;

import com.shinn.model.CartModel;

import java.util.List;

public interface ICartService {
    public List<CartModel> findByUserId(Long userId);
    public List<CartModel> findAll();
    public Long insert(CartModel cartModel);
    public CartModel findByCartId(Long cartId);
    public List<CartModel> getProduct(List<CartModel> cartModels);
    public CartModel update(CartModel cartModel);
    public void delete(CartModel cartModel);
}
