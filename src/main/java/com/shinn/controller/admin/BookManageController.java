package com.shinn.controller.admin;

import com.shinn.model.ProductModel;
import com.shinn.paging.PageRequest;
import com.shinn.paging.Pageble;
import com.shinn.services.IService.ICategoryService;
import com.shinn.services.IService.IProductService;
import com.shinn.services.impl.CategoryService;
import com.shinn.services.impl.ProductService;
import com.shinn.sort.Sorter;
import com.shinn.utils.FormUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.Pageable;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin-quan-ly-sach"})
public class BookManageController extends HttpServlet {
    private IProductService productService;
    private ICategoryService categoryService;
    public BookManageController() {
        productService = new ProductService();
        categoryService = new CategoryService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "";
        if (action != null && action.equals("addnew")) {
            url = "views/admin/EditProduct.jsp";
            req.setAttribute("listCategory", categoryService.findAll());
        } else if (action == null) {
            ProductModel product = FormUtil.toModel(ProductModel.class, req);
//            PageRequest paging = new PageRequest(product.getPage(), product.getMaxPageItem(), new Sorter(product.getSortBy(), product.getSortName()));
            PageRequest paging = new PageRequest(product.getPage(), product.getMaxPageItem(), null);
            paging.setTotalItem(productService.getTotalItem());
            if(product.getPage() != null) {
                paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / product.getMaxPageItem()));
            }
            url = "views/admin/BookManage.jsp";
            req.setAttribute("paging", paging);
            req.setAttribute("listProduct", productService.findAll(paging));
        } else if(action != null && action.equals("edit")) {
            Long id = Long.parseLong(req.getParameter("id"));
            url = "views/admin/EditProduct.jsp";
            req.setAttribute("editProduct", productService.findOne(id));
            req.setAttribute("listCategory", categoryService.findAll());
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
