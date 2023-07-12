package com.shinn.dao.impl;

import com.shinn.dao.idao.ICommentDAO;
import com.shinn.mapper.CommentMapper;
import com.shinn.model.CommentModel;

import java.util.List;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO {
    @Override
    public int countByBlogId(Long blogId) {
        String sql = "SELECT COUNT(*) FROM Comment WHERE Blog_ID=?";
        return count(sql, blogId);
    }

    @Override
    public List<CommentModel> findByBlogId(Long blogId) {
        String sql = "SELECT * FROM Comment AS c INNER JOIN User AS u ON c.User_ID=u.User_ID WHERE c.Blog_ID=?";
        return query(sql, new CommentMapper(), blogId);
    }

    @Override
    public Long insert(CommentModel commentModel) {
        String sql = "INSERT INTO Comment(Content, User_ID, Blog_ID, CreatedDate) VALUES(?,?,?,?)";
        return insert(sql, commentModel.getContent(), commentModel.getUserModel().getId(), commentModel.getBlogModel().getId(), commentModel.getCreatedDate());

    }

    @Override
    public CommentModel findById(Long id) {
        String sql = "SELECT * FROM Comment AS c INNER JOIN User AS u ON c.User_ID=u.User_ID WHERE c.Comment_ID=?";
        List<CommentModel> commentModels = query(sql, new CommentMapper(), id);
        return commentModels.isEmpty()? null: commentModels.get(0);
    }
}
