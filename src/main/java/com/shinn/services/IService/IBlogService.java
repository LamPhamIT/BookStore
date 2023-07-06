package com.shinn.services.IService;

import com.shinn.controller.web.Blog;
import com.shinn.model.BlogModel;

import java.util.List;

public interface IBlogService {
    public Long insert(BlogModel blogModel);
    public List<BlogModel> findByUserId(Long userId);
}
