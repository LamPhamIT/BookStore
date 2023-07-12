package com.shinn.services.impl;

import com.shinn.constant.SystemConstant;
import com.shinn.controller.web.Blog;
import com.shinn.dao.idao.IBlogDAO;
import com.shinn.dao.idao.ICommentDAO;
import com.shinn.dao.impl.BlogDAO;
import com.shinn.dao.impl.CommentDAO;
import com.shinn.model.BlogModel;
import com.shinn.model.CommentModel;
import com.shinn.services.IService.IBlogService;

import java.sql.Timestamp;
import java.util.List;

public class BlogService implements IBlogService {
    private IBlogDAO blogDAO;
    private ICommentDAO commentDAO;
    public BlogService() {
        blogDAO = new BlogDAO();
        commentDAO = new CommentDAO();
    }
    @Override
    public Long insert(BlogModel blogModel) {
        blogModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
       return blogDAO.insert(blogModel);

    }
    @Override
    public List<BlogModel> findByUserId(Long userId) {
        List<BlogModel> blogModels=  blogDAO.findByUserId(userId);
        for(BlogModel blogModel : blogModels) {
            blogModel.setAmountComment(commentDAO.countByBlogId(blogModel.getId()));
        }
        return blogModels;
    }

    @Override
    public BlogModel findByBlogId(Long blogId) {

        BlogModel blog= blogDAO.findByBlogId(blogId);
        blog.setAmountComment(commentDAO.countByBlogId(blog.getId()));
        blog.setComments(commentDAO.findByBlogId(blog.getId()));
        return blog;
    }

    @Override
    public void update(BlogModel blogModel) {
        blogModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        blogDAO.update(blogModel);
    }

    @Override
    public void delete(Long id) {
        blogDAO.delete(id);
    }

    @Override
    public List<BlogModel> findAll() {
        List<BlogModel> listBlog = blogDAO.findAll();
        for(BlogModel blogModel : listBlog) {
            blogModel.setAmountComment(commentDAO.countByBlogId(blogModel.getId()));
        }
        return listBlog;
    }
}
