package com.shinn.services.IService;

import com.shinn.model.UserModel;

import java.util.List;

public interface IUserService {
    public UserModel findByEmailAndPassword(String email, String password);
    public Long insertOne(UserModel user);
    public List<UserModel> findAll();
}
