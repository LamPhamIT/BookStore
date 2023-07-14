package com.shinn.dao.idao;

import com.shinn.model.ProductModel;
import com.shinn.paging.Pageble;

import java.util.List;

public interface IProductDAO {
    public Long insert(ProductModel product);
    public ProductModel findOne(Long id);
    public List<ProductModel> findAll(Pageble paging);
    public void update(ProductModel product);
    public void delete(Long id);

    public int getTotalItem();

    public List<ProductModel> findLatestProducts(int amount);
    public List<ProductModel> findSaleProducts(int amount);

    public List<ProductModel> findByCategoryID(Long categoryId);
    public List<ProductModel> find(String filter);
    public List<ProductModel> findByKeyword(String keyword);
    public void updateNum(Long id, int num);

}
