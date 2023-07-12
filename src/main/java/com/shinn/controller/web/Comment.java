package com.shinn.controller.web;

import com.google.gson.Gson;
import com.shinn.constant.SystemConstant;
import com.shinn.dao.idao.ICommentDAO;
import com.shinn.model.CommentModel;
import com.shinn.model.UserModel;
import com.shinn.services.IService.ICommentService;
import com.shinn.services.impl.CommentService;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet({"/binh-luan"})
public class Comment extends HttpServlet {
    private ICommentService commentService;
    public Comment() {
        commentService = new CommentService();
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
        CommentModel comment = gson.fromJson(json, CommentModel.class);
        comment = commentService.insert(comment);
        json = gson.toJson(comment);
        resp.getWriter().write(json);
    }
}
