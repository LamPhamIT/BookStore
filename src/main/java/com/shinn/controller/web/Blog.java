package com.shinn.controller.web;

import com.google.gson.Gson;
import com.shinn.constant.SystemConstant;
import com.shinn.model.BlogModel;
import com.shinn.model.OrderModel;
import com.shinn.model.UserModel;
import com.shinn.services.IService.IBlogService;
import com.shinn.services.IService.ICategoryService;
import com.shinn.services.impl.BlogService;
import com.shinn.services.impl.CategoryService;
import com.shinn.utils.FormUtil;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Normalizer;

@WebServlet({"/tin-tuc"})
public class Blog extends HttpServlet {
    private ICategoryService categoryService;
    private IBlogService blogService;

    public Blog() {
        categoryService = new CategoryService();
        blogService = new BlogService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String blogId = req.getParameter("blogId");
        String url = "";
        req.setAttribute("listCategory", categoryService.findAll());
        req.setAttribute("listBlog", blogService.findAll());
        if(blogId == null ) {
            if(action == null) {

                url = "/views/web/Blogs.jsp";

            } else if(action.equals("write")) {
                url = "/views/web/WriteBlog.jsp";
            } else if(action.equals("edit")) {
                BlogModel blogModel = FormUtil.toModel(BlogModel.class, req);
                blogModel =  blogService.findByBlogId(blogModel.getId());
                req.setAttribute("blogEdit", blogModel);
                url = "/views/web/WriteBlog.jsp";
            }


        } else {
            Long id = Long.parseLong(blogId);
            BlogModel blog = blogService.findByBlogId(id);
            req.setAttribute("blog",blog);
            url = "/views/web/Blog.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogModel blogModel =  FormUtil.toModel(BlogModel.class, req);
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);
        blogModel.setUser(userModel);
        Long id = blogService.insert(blogModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = req.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        Gson gson = new Gson();
        BlogModel blogModel = gson.fromJson(json, BlogModel.class);
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);
        blogModel.setUser(userModel);
        blogService.update(blogModel);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = req.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        Gson gson = new Gson();
        BlogModel blogModel = gson.fromJson(json, BlogModel.class);
        blogService.delete(blogModel.getId());
    }
}
