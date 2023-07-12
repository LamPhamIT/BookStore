package com.shinn.services.impl;

import com.shinn.dao.idao.IRoleDAO;
import com.shinn.dao.impl.RoleDAO;
import com.shinn.model.RoleModel;
import com.shinn.services.IService.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private IRoleDAO roleDAO;
    public RoleService() {
        roleDAO = new RoleDAO();
    }

    @Override
    public List<RoleModel> findAll() {
        return roleDAO.findAll();
    }
}
