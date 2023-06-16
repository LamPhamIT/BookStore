package com.shinn.services.IService;

import com.shinn.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    public List<CategoryModel> findAll();
//    public CategoryModel findOne();
    public CategoryModel findByCategoryCode(String categoryCode);
}
