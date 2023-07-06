package com.shinn.services.impl;

import com.shinn.constant.SystemConstant;
import com.shinn.dao.idao.ICategoryDAO;
import com.shinn.dao.idao.IProductDAO;
import com.shinn.dao.impl.CategoryDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.CategoryModel;
import com.shinn.model.ProductModel;
import com.shinn.model.UserModel;
import com.shinn.paging.Pageble;
import com.shinn.services.IService.IProductService;
import com.shinn.utils.SessionUtil;
import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {
    private IProductDAO productDAO;
    private ICategoryDAO categoryDAO;
    public ProductService() {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
    }

    @Override
    public ProductModel findOne(Long id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<ProductModel> findAll(Pageble paging) {
       return productDAO.findAll(paging);
    }

    @Override
    public Long save(ProductModel product) {
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel categoryModel = categoryDAO.findByCategoryCode(product.getCategoryCode());
        product.setCategory(categoryModel);
        return productDAO.insert(product);
    }

    @Override
    public void update(ProductModel product) {
        product.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        product.setModifiedBy(1L);
        CategoryModel categoryModel = categoryDAO.findByCategoryCode(product.getCategoryCode());
        product.setCategory(categoryModel);
        productDAO.update(product);
    }

    @Override
    public void delete(ProductModel product) {
        for(Long id: product.getIds()) {
            productDAO.delete(id);
        }
    }

    @Override
    public int getTotalItem() {
        return productDAO.getTotalItem();
    }

    @Override
    public List<ProductModel> findLatestProducts(int amount) {
        return productDAO.findLatestProducts(amount);
    }

    @Override
    public List<ProductModel> findSaleProducts(int amount) {
        return productDAO.findSaleProducts(amount);
    }

    @Override
    public List<ProductModel> findByCategoryCode(String categoryCode) {
        CategoryModel categoryModel = categoryDAO.findByCategoryCode(categoryCode);
        return productDAO.findByCategoryID(categoryModel.getId());
    }

    @Override
    public List<ProductModel> findByKeyWord(String keyword) {
        return productDAO.findByKeyword(keyword);
    }
}
