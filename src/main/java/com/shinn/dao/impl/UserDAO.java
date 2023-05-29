package com.shinn.dao.impl;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.mapper.UserMapper;
import com.shinn.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM User";
        return query(sql, new UserMapper());
    }

    @Override
    public UserModel findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM User as u INNER JOIN Role as r ON u.Role_ID=r.Role_ID WHERE Email=? AND Password=?";
        List<UserModel> result = query(sql, new UserMapper(), email, password);
        return result.isEmpty() ? null : result.get(0);
    }
}
