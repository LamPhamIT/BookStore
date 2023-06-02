package com.shinn.controller.web;

import com.shinn.model.UserModel;
import com.shinn.services.IService.IUserService;
import com.shinn.services.impl.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/test"})
public class test extends HttpServlet {
    private IUserService userService;
    public test() {
        userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> list = userService.findAll();
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/web/data.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("filePath");
        boolean result = Writer.getInstance().writeExcel(userService.findAll(), path);

    }
}
