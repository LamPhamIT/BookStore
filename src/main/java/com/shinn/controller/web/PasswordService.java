package com.shinn.controller.web;

import com.shinn.mailservice.MailSender;
import com.shinn.model.UserModel;
import com.shinn.services.IService.IUserService;
import com.shinn.services.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/forget-password"})
public class PasswordService extends HttpServlet {
    private IUserService userService;
    public PasswordService() {
        userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        UserModel user = userService.findByEmail(email);
        MailSender sender = new MailSender();
        boolean result  = sender.sendEmail(email, user.getPassword());
    }
}
