package com.shinn.controller.admin;
import com.shinn.fileservice.IWriter;
import com.shinn.fileservice.ProductWriter;
import com.shinn.model.ProductModel;
import com.shinn.paging.PageRequest;
import com.shinn.services.IService.IProductService;
import com.shinn.services.impl.ProductService;
import com.shinn.sort.Sorter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-export-file"})
public class ExportFile extends HttpServlet {
    private IProductService productService;
    public ExportFile() {
        productService = new ProductService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortBy= req.getParameter("sortBy");
        String sortName=req.getParameter("sortName");
        String filePath=req.getParameter("filePath");
        IWriter<ProductModel> writer = new ProductWriter();
        writer.write(productService.findAll(new PageRequest(null, null, new Sorter(sortBy, sortName))), filePath);
        resp.sendRedirect(req.getContextPath() +  "/admin-quan-ly-sach?page=1&maxPageItem=2&sortBy=Product_ID&sortName=asc");
    }
}
