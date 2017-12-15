package web.service;

import web.po.Userlogin;

public interface UserloginService {

    //根据名字查找用户
    Userlogin findByName(String name) throws Exception;

    //根据用户名更新
    void updateByName(String name, Userlogin userlogin) throws Exception;

}
