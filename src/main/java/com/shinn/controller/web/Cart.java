package com.shinn.controller.web;

import com.google.gson.Gson;
import com.shinn.constant.SystemConstant;
import com.shinn.model.CartModel;
import com.shinn.model.ProductModel;
import com.shinn.model.UserModel;
import com.shinn.services.IService.ICartService;
import com.shinn.services.IService.IProductService;
import com.shinn.services.impl.CartService;
import com.shinn.services.impl.ProductService;
import com.shinn.utils.FormUtil;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet({"/cart"})
public class Cart extends HttpServlet {

    private ICartService cartService;
    private IProductService productService;
    public Cart() {
        cartService = new CartService();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartModel cartModel = FormUtil.toModel(CartModel.class, req);
        ProductModel productModel = new ProductModel();
        productModel = productService.findOne(Long.parseLong(req.getParameter("product_id")));
        cartModel.setProduct(productModel);
        UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER);
        if (user == null) {
//            addCartToCookie(req, resp, cartModel);
            Gson gson = new Gson();
            resp.setContentType("application/json");
            PrintWriter printWriter = resp.getWriter();
            String json = gson.toJson(cartModel);
            printWriter.print(json);
            printWriter.flush();
            printWriter.close();
        } else {
            cartModel.setUser(user);
            Long id = cartService.insert(cartModel);
        }
    }
}
