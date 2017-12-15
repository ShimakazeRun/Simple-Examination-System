package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.mapper.UserloginMapper;
import web.po.Userlogin;
import web.po.UserloginExample;
import web.service.UserloginService;

import java.util.List;

@Service
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public Userlogin findByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        List<Userlogin> list = userloginMapper.selectByExample(userloginExample);

        return list.get(0);
    }

    @Override
    public void updateByName(String name, Userlogin userlogin) throws Exception {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }
}
