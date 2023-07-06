package com.shinn.mapper;

import com.shinn.model.BlogStatusModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogStatusMapper implements RowMapper<BlogStatusModel> {
    @Override
    public BlogStatusModel mapRow(ResultSet resultSet) {
        BlogStatusModel blogStatusModel = new BlogStatusModel();
        try {
            blogStatusModel.setId(resultSet.getLong("Status_ID"));
            blogStatusModel.setName(resultSet.getString("Name"));
            return blogStatusModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
