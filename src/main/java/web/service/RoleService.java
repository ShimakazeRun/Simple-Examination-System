package web.service;

import web.po.Role;

public interface RoleService {

    Role findByid(Integer id) throws Exception;
}
