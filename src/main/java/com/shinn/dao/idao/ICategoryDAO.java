package com.shinn.dao.idao;

import com.shinn.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    public List<CategoryModel> findAll();
    public CategoryModel findByCategoryCode(String categoryCode);
}
