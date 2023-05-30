package com.shinn.dao.idao;

import com.shinn.model.UserModel;

import java.util.List;

public interface IUserDAO {
    public List<UserModel> findAll();
    public UserModel findByEmailAndPassword(String email, String password);
    public Long insertOne(UserModel user);
}
