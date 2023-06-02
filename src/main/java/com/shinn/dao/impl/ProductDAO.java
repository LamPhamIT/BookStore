package com.shinn.dao.impl;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.mapper.ProductMapper;
import com.shinn.model.ProductModel;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

    @Override
    public Long insert(ProductModel product) {
        String sql = "INSERT INTO Product(Title, Thumbnail, Description, Price, Discount, Remain_Quality, Category_ID, Created_Date) VALUES (?,?,?,?,?,?,?,?)";
        return insert(sql, product.getTitle(), product.getThumbnail(), product.getDescription(), product.getPrice(),
        product.getDiscount(), product.getRemainQuality(), product.getCategory().getId(), product.getCreatedDate());
    }

    @Override
    public ProductModel findOne(Long id) {
        String sql = "SELECT * FROM Product as p INNER JOIN Category as c ON p.Category_ID=c.Category_ID WHERE p.Product_ID=?";
        List<ProductModel> list = query(sql, new ProductMapper(), id);
        return list.isEmpty()? null : list.get(0);
    }

    @Override
    public List<ProductModel> findAll() {
       String sql = "SELECT * FROM Product as p INNER JOIN Category as c ON p.Category_ID=c.Category_ID";
       return query(sql, new ProductMapper());
    }
}
