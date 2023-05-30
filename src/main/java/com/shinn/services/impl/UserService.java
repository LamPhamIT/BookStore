package com.shinn.services.impl;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.dao.impl.UserDAO;
import com.shinn.model.UserModel;
import com.shinn.services.IService.IUserService;
import javax.inject.Inject;

public class UserService implements IUserService {
//    @Inject
    private IUserDAO userDAO;
    public UserService() {
        userDAO = new UserDAO();
    }
    @Override
    public UserModel findByEmailAndPassword(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
    }

    @Override
    public Long insertOne(UserModel user) {
        return userDAO.insertOne(user);
    }
}
