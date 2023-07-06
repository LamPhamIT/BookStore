package com.shinn.dao.impl;

import com.shinn.dao.idao.IBlogDAO;
import com.shinn.mapper.BlogMapper;
import com.shinn.model.BlogModel;

import java.util.List;

public class BlogDAO extends AbstractDAO<BlogModel> implements IBlogDAO {
    @Override
    public Long insert(BlogModel blog) {
        String sql = "INSERT INTO Blog(Title, Thumbnail, Content, User_ID, Status_ID, CreatedDate) VALUES(?, ?, ?, ?, ?, ?)";
        return insert(sql, blog.getTitle(), blog.getThumbnail(), blog.getContent(), blog.getUser().getId(), 1L,blog.getCreatedDate());
    }

    @Override
    public List<BlogModel> findByUserId(Long userId) {
        String sql = "SELECT * FROM Blog As b INNER JOIN Blog_Status as s ON b.Status_ID=s.Status_ID WHERE User_ID=?";
        return query(sql, new BlogMapper(), userId);
    }
}
