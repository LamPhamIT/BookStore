package com.shinn.dao.impl;

import com.shinn.dao.idao.ICategoryDAO;
import com.shinn.mapper.CategoryMapper;
import com.shinn.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM Category";
        return query(sql, new CategoryMapper());
    }

    @Override
    public CategoryModel findByCategoryCode(String categoryCode) {
        String sql = "SELECT * FROM Category WHERE Category_Code=?";
        List<CategoryModel> list = query(sql, new CategoryMapper(), categoryCode);
        return list.isEmpty()? null : list.get(0);
    }
}
