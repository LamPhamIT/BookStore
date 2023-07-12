package com.shinn.controller.admin;

import com.shinn.services.IService.IOrderService;
import com.shinn.services.IService.IStatisticService;
import com.shinn.services.impl.OrderService;
import com.shinn.services.impl.StatisticService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-trang-chu"})
public class Home extends HttpServlet {
    private IStatisticService statisticService;
    private IOrderService orderService;
    public Home() {
        statisticService = new StatisticService();
        orderService = new OrderService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("earningMonth", statisticService.statisticByCurrentMonth());
        req.setAttribute("avgMonth", statisticService.statisticAVGByMonth());
        req.setAttribute("ordered", orderService.countOrdered());
        req.setAttribute("unconfirmed", orderService.countUnconfirmed());
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/Home.jsp");
        rd.forward(req, resp);
    }
}
