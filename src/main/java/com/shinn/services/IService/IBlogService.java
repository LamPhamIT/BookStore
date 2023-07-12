package com.shinn.services.IService;

import com.shinn.model.BlogModel;

import java.util.List;

public interface IBlogService {
    public Long insert(BlogModel blogModel);
    public List<BlogModel> findByUserId(Long userId);
    public BlogModel findByBlogId(Long blogId);
    public void update(BlogModel blogModel);
    public void delete(Long id);
    public List<BlogModel> findAll();
}
