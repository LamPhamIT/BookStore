package com.shinn.mapper;

import com.shinn.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet resultSet) {
        RoleModel role = new RoleModel();
        try {
            role.setId(resultSet.getLong("Role_ID"));
            role.setName(resultSet.getString("Role_Name"));
            return role;
        } catch (SQLException e) {
            return null;
        }

    }
}
