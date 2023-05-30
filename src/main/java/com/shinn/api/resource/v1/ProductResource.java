package com.shinn.api.resource.v1;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.dao.impl.UserDAO;
import com.shinn.model.UserModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/books")
public class ProductResource {
    public IUserDAO userDAO;
    public ProductResource() {
        userDAO = new UserDAO();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> getAllUser() {
        return userDAO.findAll();
    }
}
