package com.shinn.controller.admin;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import com.shinn.services.IService.IOrderService;
import com.shinn.services.impl.OrderService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/admin-quan-ly-don-hang"})
public class Order extends HttpServlet {
    private IOrderService orderService;
    public Order() {
        orderService = new OrderService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listOrder", orderService.findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/OrderManage.jsp");
        rd.forward(req, resp);
    }
}
