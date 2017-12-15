package web.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.po.Role;
import web.po.Userlogin;
import web.service.RoleService;
import web.service.UserloginService;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm{

    @Autowired
    private UserloginService userloginService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) getAvailablePrincipal(principalCollection);

        Role role = null;

        try {
            Userlogin userlogin = userloginService.findByName(username);
            //获取角色对象
            role = roleService.findByid(userlogin.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过用户名从数据库获取权限和角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if (role != null) {
            r.add(role.getRolename());
            info.setRoles(r);
        }

        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        Userlogin userlogin = null;
        try {
            userlogin = userloginService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userlogin == null) {
            //没有用户名
            throw new UnknownAccountException();
        } else if (!password.equals(userlogin.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        }

        //身份验证通过 返回一个身份信息
        //AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
