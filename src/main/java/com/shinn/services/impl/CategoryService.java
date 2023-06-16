package com.shinn.services.impl;

import com.shinn.dao.idao.ICategoryDAO;
import com.shinn.dao.impl.CategoryDAO;
import com.shinn.model.CategoryModel;
import com.shinn.services.IService.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryDAO categoryDAO;
    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }
    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryModel findByCategoryCode(String categoryCode) {
        return categoryDAO.findByCategoryCode(categoryCode);
    }
}
