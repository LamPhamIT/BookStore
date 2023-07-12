package com.shinn.dao.impl;

import com.shinn.dao.idao.IRoleDAO;
import com.shinn.mapper.RoleMapper;
import com.shinn.model.RoleModel;

import javax.management.relation.Role;
import java.util.List;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {
    @Override
    public List<RoleModel> findAll() {
        String sql = "SELECT * FROM Role";
        return query(sql, new RoleMapper());
    }
}
