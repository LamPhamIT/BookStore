package com.shinn.dao.idao;

import com.shinn.model.ProductModel;

import java.util.List;

public interface IProductDAO {
    public Long insert(ProductModel product);
    public ProductModel findOne(Long id);
    public List<ProductModel> findAll();
}
