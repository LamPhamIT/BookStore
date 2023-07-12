package com.shinn.controller.admin;

import com.shinn.model.UserModel;
import com.shinn.services.IService.IRoleService;
import com.shinn.services.IService.IUserService;
import com.shinn.services.impl.RoleService;
import com.shinn.services.impl.UserService;
import com.shinn.utils.FormUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/admin-quan-ly-tai-khoan"})
public class User extends HttpServlet {
    private IUserService userService;
    private IRoleService roleService;

    public User() {
        userService = new UserService();
        roleService = new RoleService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "";
        if (action == null) {
            req.setAttribute("listUser", userService.findAll());
            url = "/views/admin/UserManage.jsp";
        } else if (action.equals("addNew")) {
            req.setAttribute("listRole", roleService.findAll());
            url = "/views/admin/EditUser.jsp";
        } else if (action.equals("edit")) {
            UserModel user = FormUtil.toModel(UserModel.class, req);
            req.setAttribute("listRole", roleService.findAll());
            req.setAttribute("editUser", userService.findById(user.getId()));
            url = "/views/admin/EditUser.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
