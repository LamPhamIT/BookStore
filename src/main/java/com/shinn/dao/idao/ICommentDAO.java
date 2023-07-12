package com.shinn.dao.idao;

import com.shinn.model.CommentModel;

import java.util.List;

public interface ICommentDAO {
    public int countByBlogId(Long blogId);
    public List<CommentModel> findByBlogId(Long blogId);
    public Long insert(CommentModel commentModel);
    public CommentModel findById(Long id);
}
