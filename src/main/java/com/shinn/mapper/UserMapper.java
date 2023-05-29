package com.shinn.mapper;

import com.shinn.model.RoleModel;
import com.shinn.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet) {
       UserModel user = new UserModel();
        try {
            user.setId(resultSet.getLong("User_ID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            user.setFirstName(resultSet.getString("First_Name"));
            user.setLastName(resultSet.getString("Last_Name"));
            user.setPhoneNumber(resultSet.getString("Phone_Number"));
           try {
               RoleModel role = new RoleMapper().mapRow(resultSet);
               user.setRole(role);
           }catch (Exception e) {
              e.printStackTrace();
           }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
