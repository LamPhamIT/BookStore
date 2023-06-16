package com.shinn.controller.web;

import com.shinn.constant.SystemConstant;
import com.shinn.model.UserModel;
import com.shinn.services.IService.ICategoryService;
import com.shinn.services.IService.IProductService;
import com.shinn.services.IService.IUserService;
import com.shinn.services.impl.CategoryService;
import com.shinn.services.impl.ProductService;
import com.shinn.services.impl.UserService;
import com.shinn.utils.FormUtil;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/dang-ky"})
public class HomeController extends HttpServlet {
    private IUserService userService;
    private IProductService productService;
    private ICategoryService categoryService;

    public HomeController() {
        userService = new UserService();
        productService = new ProductService();
        categoryService = new CategoryService();
    }

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            String message = req.getParameter("message");
            String alert = req.getParameter("alert");
            if (message != null && alert != null) {
                req.setAttribute("message", resourceBundle.getString(message));
                req.setAttribute("alert", alert);
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/web/Login.jsp");
            requestDispatcher.forward(req, resp);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(req, SystemConstant.USER);
            resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
        } else if (action != null && action.equals("signup")) {
            SessionUtil.getInstance().removeValue(req, SystemConstant.USER);
            String message = req.getParameter("message");
            String alert = req.getParameter("alert");
            if(message != null && alert != null) {
                req.setAttribute("message", resourceBundle.getString(message));
                req.setAttribute("alert", alert);
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/Signup.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("listCategory", categoryService.findAll());
            req.setAttribute("listLatest", productService.findLatestProducts(4));
            req.setAttribute("listSale", productService.findSaleProducts(8));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/web/Home.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel user = FormUtil.toModel(UserModel.class, req);
            user = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (user != null) {
                SessionUtil.getInstance().putValue(req, SystemConstant.USER, user);
                if (user.getRole().getName().equals(SystemConstant.USER_ROLE)) {
                    resp.sendRedirect(req.getContextPath() + "/trang-chu");
                } else if (user.getRole().getName().equals(SystemConstant.ADMIN_ROLE)) {
//                    resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
                    resp.sendRedirect(req.getContextPath() + "/admin-trang-chu");
                }

            } else {
                resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username_password_unvalid&alert=danger");
            }
        } else if (action != null && action.equals("signup")) {
            UserModel user = FormUtil.toModel(UserModel.class, req);
            if(user != null) {
                Long id = userService.insertOne(user);
                if(id == null) {
                    resp.sendRedirect(req.getContextPath() + "/dang-ky?action=signup&message=signup_fail&alert=danger");
                } else {
                    SessionUtil.getInstance().putValue(req, SystemConstant.USER, user);
                    resp.sendRedirect(req.getContextPath() + "/trang-chu");
                }
            }
        }
    }
}
