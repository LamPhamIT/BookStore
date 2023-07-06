package com.shinn.mapper;

import com.shinn.model.BlogModel;
import com.shinn.model.BlogStatusModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogMapper implements RowMapper<BlogModel> {
    @Override
    public BlogModel mapRow(ResultSet resultSet) {
        BlogModel blogModel = new BlogModel();
        try {
            blogModel.setCreatedDate(resultSet.getTimestamp("CreatedDate"));
            blogModel.setId(resultSet.getLong("Blog_ID"));
            blogModel.setTitle(resultSet.getString("Title"));
            blogModel.setThumbnail(resultSet.getString("Thumbnail"));
            blogModel.setContent(resultSet.getString("Content"));
            try {
                UserMapper user = new UserMapper();
                blogModel.setUser(user.mapRow(resultSet));

            }catch (Exception e) {
            }
            try {
                BlogStatusMapper blogStatusMapper = new BlogStatusMapper();
                blogModel.setBlogStatus(blogStatusMapper.mapRow(resultSet));
            }catch (Exception e) {
            }
            return blogModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
