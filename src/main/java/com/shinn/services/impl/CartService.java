package com.shinn.services.impl;

import com.shinn.dao.idao.ICartDAO;
import com.shinn.dao.idao.IProductDAO;
import com.shinn.dao.impl.CartDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.CartModel;
import com.shinn.model.ProductModel;
import com.shinn.services.IService.ICartService;

import java.sql.Timestamp;
import java.util.List;

public class CartService implements ICartService {
    private ICartDAO cartDAO;
    private IProductDAO productDAO;

    public CartService() {
        cartDAO = new CartDAO();
        productDAO = new ProductDAO();
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
        cartModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        List<CartModel> listCart = cartDAO.findByUserId(cartModel.getUser().getId());
        boolean check = false;
        for (CartModel cart : listCart) {
            if (cart.getProduct().getId() == cartModel.getProduct().getId()) {
                cartModel.setId(cart.getId());
                cartModel.setNum(cart.getNum() + 1);
                check = true;
                break;
            }
        }
        if (check == false)
            return cartDAO.insert(cartModel);
        cartDAO.update(cartModel);
        return cartModel.getId();
    }

    @Override
    public CartModel findByCartId(Long cartId) {
        return cartDAO.findByCartId(cartId);
    }

    @Override
    public List<CartModel> getProduct(List<CartModel> cartModels) {
        for (CartModel cartModel : cartModels) {
            ProductModel productModel = productDAO.findOne(cartModel.getProduct().getId());
            cartModel.setProduct(productModel);
        }
        return cartModels;
    }

    @Override
    public CartModel update(CartModel cartModel) {
        cartDAO.update(cartModel);
        return cartDAO.findByCartId(cartModel.getId());
    }

    @Override
    public void delete(CartModel cartModel) {
        for(int i = 0; i < cartModel.getIds().length;i++) {
            cartDAO.delete(cartModel.getIds()[i]);
        }
    }
}
