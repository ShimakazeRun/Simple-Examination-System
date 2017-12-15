package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mapper.RoleMapper;
import web.po.Role;
import web.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findByid(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
