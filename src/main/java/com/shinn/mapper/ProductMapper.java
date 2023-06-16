package com.shinn.mapper;

import com.shinn.model.CategoryModel;
import com.shinn.model.ProductModel;
import jdk.jfr.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductModel>{
    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        ProductModel product = new ProductModel();
        try {
            product.setId(resultSet.getLong("Product_ID"));
            product.setTitle(resultSet.getString("Title"));
            product.setThumbnail(resultSet.getString("Thumbnail"));
            product.setDescription(resultSet.getString("Description"));
            product.setPrice(resultSet.getLong("Price"));
            product.setDiscount(resultSet.getLong("Discount"));
            product.setRemainQuality(resultSet.getInt("Remain_Quality"));
            CategoryModel category = new CategoryModel();
            try {
                category.setId(resultSet.getLong("Category_ID"));
                category.setCategoryName(resultSet.getString("Category_Name"));
                category.setCategoryCode(resultSet.getString("Category_Code"));
                product.setCategory(category);
            }catch(Exception e) {
                product.setCategory(category);
            }
            return product;
        } catch (SQLException e) {
            return null;
        }
    }
}
