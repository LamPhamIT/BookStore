package com.shinn.controller.web;

import com.shinn.model.ProductModel;
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
import java.util.List;


@WebServlet({"/tim-kiem"})
public class Search extends HttpServlet {
    private IProductService productService;
    private ICategoryService categoryService;
    public Search() {
        productService = new ProductService();
        categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        String type = req.getParameter("type");
        req.setAttribute("listCategory", categoryService.findAll());
        if(type.equals("product")) {
            List<ProductModel> listResult = productService.findByKeyWord(query);
            req.setAttribute("listResult", listResult);
            req.setAttribute("numberOfProduct", listResult.size());
            req.setAttribute("keyword", query);
        }
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("/views/web/FindResult.jsp");
        requestDispatcher.forward(req, resp);
    }
}
