package com.shinn.mapper;

import com.shinn.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel category = new CategoryModel();
        try {
            category.setId(resultSet.getLong("Category_ID"));
            category.setCategoryName(resultSet.getString("Category_Name"));
            category.setCategoryCode(resultSet.getString("Category_code"));
            return category;
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            return null;
        }
    }
}
