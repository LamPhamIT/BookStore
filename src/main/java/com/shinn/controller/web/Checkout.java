package com.shinn.controller.web;

import com.google.gson.Gson;
import com.shinn.constant.SystemConstant;
import com.shinn.model.OrderModel;
import com.shinn.model.OrderProductModel;
import com.shinn.model.UserModel;
import com.shinn.paging.Pageble;
import com.shinn.services.IService.ICartService;
import com.shinn.services.IService.IOrderService;
import com.shinn.services.impl.CartService;
import com.shinn.services.impl.OrderService;
import com.shinn.utils.FormUtil;
import com.shinn.utils.SessionUtil;
import jakarta.persistence.criteria.Order;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet({"/thanh-toan"})
public class Checkout extends HttpServlet {
    private IOrderService orderService;
    private ICartService cartService;

    public Checkout() {
        orderService = new OrderService();
        cartService = new CartService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/CheckOut.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = req.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        Gson gson = new Gson();
        OrderModel orderModel = gson.fromJson(json, OrderModel.class);
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);

        if (userModel != null) {
            orderModel.setUser(userModel);
            cartService.deleteByUserID(userModel.getId());
        }
        orderService.insert(orderModel);
    }
}
