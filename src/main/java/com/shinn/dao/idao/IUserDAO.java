package com.shinn.dao.idao;

import com.shinn.model.UserModel;

import java.util.List;

public interface IUserDAO {
    public List<UserModel> findAll();
    public UserModel findByEmailAndPassword(String email, String password);
    public Long insertOne(UserModel user);
    public void updatePasswordById(UserModel userModel);
    public UserModel findByEmail(String email);
    public UserModel findById(Long id);
    public void update(UserModel user);
}
