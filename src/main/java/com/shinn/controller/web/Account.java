package com.shinn.controller.web;

import com.shinn.constant.SystemConstant;
import com.shinn.model.OrderModel;
import com.shinn.model.UserModel;
import com.shinn.services.IService.IOrderService;
import com.shinn.services.impl.OrderService;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/tai-khoan"})
public class Account extends HttpServlet {
    private IOrderService orderService;
    public Account() {
        orderService = new OrderService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);

        if(userModel != null) {
            List<OrderModel> orderLists = orderService.findByUserId(userModel.getId());
            req.setAttribute("listOrders", orderLists);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/Account.jsp");
        rd.forward(req, resp);
    }
}
