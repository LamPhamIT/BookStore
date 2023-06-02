package com.shinn.services.IService;

import com.shinn.model.ProductModel;

import java.util.List;

public interface IProductService {
    public ProductModel findOne(Long id);
    public List<ProductModel> findAll();
    public Long save(ProductModel product);
}
