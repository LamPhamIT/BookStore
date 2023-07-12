package com.shinn.dao.impl;

import com.shinn.dao.idao.IBlogDAO;
import com.shinn.mapper.BlogMapper;
import com.shinn.model.BlogModel;

import java.util.List;

public class BlogDAO extends AbstractDAO<BlogModel> implements IBlogDAO {
    @Override
    public Long insert(BlogModel blog) {
        String sql = "INSERT INTO Blog(Title, Thumbnail, Content, User_ID, Status_ID, CreatedDate) VALUES(?, ?, ?, ?, ?, ?)";
        return insert(sql, blog.getTitle(), blog.getThumbnail(), blog.getContent(), blog.getUser().getId(), 1L, blog.getCreatedDate());
    }

    @Override
    public List<BlogModel> findByUserId(Long userId) {
        String sql = "SELECT * FROM Blog As b INNER JOIN Blog_Status as s ON b.Status_ID=s.Status_ID WHERE User_ID=?";
        return query(sql, new BlogMapper(), userId);
    }

    @Override
    public BlogModel findByBlogId(Long blogId) {
        String sql = "SELECT * FROM Blog As b INNER JOIN Blog_Status as s ON b.Status_ID=s.Status_ID INNER JOIN User As u ON u.User_ID=b.User_ID WHERE Blog_ID=?";

        List<BlogModel> blogModels = query(sql, new BlogMapper(), blogId);
        return blogModels.isEmpty() ? null : blogModels.get(0);
    }

    @Override
    public void update(BlogModel blogModel) {
        String sql = "UPDATE Blog SET Title=?, Thumbnail=?, Content=?, User_ID=?, Status_ID=?, ModifiedDate=? WHERE Blog_ID=?";
        update(sql, blogModel.getTitle(), blogModel.getThumbnail(), blogModel.getContent(),
                                    blogModel.getUser().getId(), 1L, blogModel.getModifiedDate(), blogModel.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Blog WHERE Blog_ID=?";
        update(sql, id);
    }

    @Override
    public List<BlogModel> findAll() {
        String sql = "SELECT * FROM Blog As b INNER JOIN Blog_Status as s ON b.Status_ID=s.Status_ID INNER JOIN User As u ON u.User_ID=b.User_ID";
        return query(sql, new BlogMapper());
    }
}
