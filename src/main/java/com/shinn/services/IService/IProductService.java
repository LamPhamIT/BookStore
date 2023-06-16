package com.shinn.services.IService;

import com.shinn.model.ProductModel;
import com.shinn.paging.Pageble;

import java.util.List;

public interface IProductService {
    public List<ProductModel> findByCategoryCode(String categoryCode);
    public ProductModel findOne(Long id);
    public List<ProductModel> findAll(Pageble paging);
    public Long save(ProductModel product);
    public void update(ProductModel product);
    public void delete(ProductModel product);
    public int getTotalItem();
    public List<ProductModel> findLatestProducts(int amount);
    public List<ProductModel> findSaleProducts(int amount);
}
