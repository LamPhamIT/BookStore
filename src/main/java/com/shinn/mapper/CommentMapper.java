package com.shinn.mapper;

import com.shinn.model.CommentModel;
import com.shinn.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<CommentModel> {
    @Override
    public CommentModel mapRow(ResultSet resultSet) {
        CommentModel commentModel = new CommentModel();
        try {
            commentModel.setContent(resultSet.getString("Content"));
            UserModel userModel = new UserModel();
            userModel.setFirstName(resultSet.getString("First_Name"));
            userModel.setLastName(resultSet.getString("Last_Name"));
            commentModel.setUserModel(userModel);
            commentModel.setCreatedDate(resultSet.getTimestamp("CreatedDate"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commentModel;
    }
}
