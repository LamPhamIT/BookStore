package com.shinn.services.impl;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.ProductModel;
import com.shinn.services.IService.IProductService;

import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {
    private IProductDAO productDAO;
    public ProductService() {
        productDAO = new ProductDAO();
    }

    @Override
    public ProductModel findOne(Long id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<ProductModel> findAll() {
       return productDAO.findAll();
    }

    @Override
    public Long save(ProductModel product) {
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return productDAO.insert(product);
    }
}
