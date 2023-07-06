package com.shinn.services.impl;

import com.shinn.constant.SystemConstant;
import com.shinn.controller.web.Blog;
import com.shinn.dao.idao.IBlogDAO;
import com.shinn.dao.impl.BlogDAO;
import com.shinn.model.BlogModel;
import com.shinn.services.IService.IBlogService;

import java.sql.Timestamp;
import java.util.List;

public class BlogService implements IBlogService {
    private IBlogDAO blogDAO;
    public BlogService() {
        blogDAO = new BlogDAO();
    }
    @Override
    public Long insert(BlogModel blogModel) {
        blogModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
       return blogDAO.insert(blogModel);

    }
    @Override
    public List<BlogModel> findByUserId(Long userId) {
        return blogDAO.findByUserId(userId);
    }
}
