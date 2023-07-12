package com.shinn.services.impl;

import com.shinn.dao.idao.ICommentDAO;
import com.shinn.dao.impl.CommentDAO;
import com.shinn.model.CommentModel;
import com.shinn.services.IService.ICommentService;

import java.sql.Timestamp;

public class CommentService implements ICommentService {
    private ICommentDAO commentDAO;
    public CommentService() {
        commentDAO = new CommentDAO();
    }
    @Override
    public CommentModel insert(CommentModel commentModel) {
        commentModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Long id = commentDAO.insert(commentModel);
        return commentDAO.findById(id);
    }
}
