package com.shinn.services.impl;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.dao.impl.UserDAO;
import com.shinn.model.UserModel;
import com.shinn.services.IService.IUserService;
import javax.inject.Inject;
import java.util.List;

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

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean updatePasswordById(UserModel userModel) {
       UserModel userCheck = userDAO.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(userCheck == null) {
            return false;
        }
        userDAO.updatePasswordById(userModel);
        return true;
    }

    @Override
    public UserModel findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public UserModel findById(Long id) {
       return userDAO.findById(id);
    }

    @Override
    public void updateUser(UserModel user) {

    }
}
