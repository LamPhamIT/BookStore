package com.shinn.api.resource.v1;

import com.shinn.model.UserModel;
import com.shinn.services.IService.IUserService;
import com.shinn.services.impl.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("v1/users")
public class UserResource {
    private IUserService userService;
    public UserResource() {
        userService = new UserService();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserModel insert(UserModel userModel) {
        Long id = userService.insertOne(userModel);
        return userService.findById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(UserModel userModel) {

    }
}
