package com.shinn.controller.web;

import com.google.gson.Gson;
import com.shinn.constant.SystemConstant;
import com.shinn.model.BlogModel;
import com.shinn.model.OrderModel;
import com.shinn.model.UserModel;
import com.shinn.services.IService.IBlogService;
import com.shinn.services.IService.ICategoryService;
import com.shinn.services.IService.IOrderService;
import com.shinn.services.IService.IUserService;
import com.shinn.services.impl.BlogService;
import com.shinn.services.impl.CategoryService;
import com.shinn.services.impl.OrderService;
import com.shinn.services.impl.UserService;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet({"/tai-khoan"})
public class Account extends HttpServlet {
    private IOrderService orderService;
    private IBlogService blogService;
    private IUserService userService;
    private ICategoryService categoryService;

    public Account() {
        orderService = new OrderService();
        blogService = new BlogService();
        userService = new UserService();
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);
        req.setAttribute("listCategory", categoryService.findAll());
        if (userModel != null) {
            List<OrderModel> orderLists = orderService.findByUserId(userModel.getId());
            List<BlogModel> blogModels = blogService.findByUserId(userModel.getId());
            req.setAttribute("listBlogs", blogModels);
            req.setAttribute("listOrders", orderLists);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/Account.jsp");
        rd.forward(req, resp);

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
        UserModel userSession = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);
        UserModel user = gson.fromJson(json, UserModel.class);
        user.setId(userSession.getId());
        user.setEmail(userSession.getEmail());
        userService.updatePasswordById(user);
    }
}
