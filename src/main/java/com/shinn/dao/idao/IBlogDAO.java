package com.shinn.dao.idao;

import com.shinn.model.BlogModel;

import java.util.List;

public interface IBlogDAO {
    public Long insert(BlogModel blog);
    public List<BlogModel> findByUserId(Long userId);
}
