package com.shinn.dao.impl;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.mapper.UserMapper;
import com.shinn.model.RoleModel;
import com.shinn.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM User as u INNER JOIN Role as r ON u.Role_ID=r.Role_ID";
        return query(sql, new UserMapper());
    }

    @Override
    public UserModel findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM User as u INNER JOIN Role as r ON u.Role_ID=r.Role_ID WHERE Email=? AND Password=?";
        List<UserModel> result = query(sql, new UserMapper(), email, password);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long insertOne(UserModel user) {
        String sql = "INSERT INTO User(Email, Password, First_Name, Last_Name, Phone_Number, Role_ID) VALUES(?,?,?,?,?,?)";
        if(user.getRole() == null) {
            RoleModel role = new RoleModel();
            role.setId(2L);
            user.setRole(role);
        }
        return insert(sql, user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getRole().getId());
    }

    @Override
    public void updatePasswordById(UserModel userModel) {
        String sql = "UPDATE User SET Password=? WHERE User_ID=?";
        update(sql, userModel.getNewPassword(), userModel.getId());
    }

    @Override
    public UserModel findByEmail(String email) {
        String sql = "SELECT * FROM User WHERE Email=?";
        List<UserModel> userModels = query(sql, new UserMapper(), email);
        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public UserModel findById(Long id) {
        String sql = "SELECT * FROM User as u INNER JOIN Role as r ON u.Role_ID=r.Role_ID WHERE User_ID=?";
        List<UserModel> list = query(sql, new UserMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void update(UserModel user) {
        String sql = "UPDATE User set Email=?, First_Name=?, Last_Name=?, Phone_Number=?, Modified_Date=?, Role_Id=?";
        update(sql, user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getModifiedDate(), user.getRole().getId());
    }
}
