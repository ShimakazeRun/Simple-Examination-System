package web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.exception.CustomException;
import web.po.Userlogin;
import web.service.UserloginService;

@Controller
public class RestPasswordController {

    @Autowired
    private UserloginService userloginService;

    //账户密码重置
    @RequestMapping(value = "/passwordRest", method = RequestMethod.POST)
    public String passwordRest(String oldPassword, String newPassword) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        Userlogin userlogin = userloginService.findByName(username);

        if (!oldPassword.equals(userlogin.getPassword())) {
            throw new CustomException("旧密码不正确");
        } else {
            userlogin.setPassword(newPassword);
            userloginService.updateByName(username, userlogin);
        }

        return "redirect:/logout";
    }
}
