package com.shinn.controller.web;

import com.shinn.services.IService.ICategoryService;
import com.shinn.services.IService.IProductService;
import com.shinn.services.impl.CategoryService;
import com.shinn.services.impl.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/danh-muc"})
public class Category extends HttpServlet {
    private IProductService productService;
    private ICategoryService categoryService;
    public Category() {
        productService = new ProductService();
        categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryCode = req.getParameter("categoryCode");
        req.setAttribute("listProducts", productService.findByCategoryCode(categoryCode));
        req.setAttribute("listCategory", categoryService.findAll());
        req.setAttribute("category", categoryService.findByCategoryCode(categoryCode));
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/CategoryDetail.jsp");
        rd.forward(req, resp);
    }
}
