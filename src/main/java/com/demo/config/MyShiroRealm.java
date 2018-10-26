package com.demo.config;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/17 0:00
 * @comment: 备注
 * @version: V1.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    //private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

   /* @Autowired
    private IUserDao userDao;*/
   @Autowired
   private UserMapper userDao;

    /**

    /** 
     * @description : 一句话描述功能;
     * * 权限认证，为当前登录的Subject授予角色和权限
     * @see ：本例中该方法的调用时机为需授权资源被访问时
     * @see ：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
     * @see ：如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），
     * 超过这个时间间隔再刷新页面，该方法会被执行

     * @author : 周海涛
     * @date : 2018/6/17 0:02
     * @param : [principalCollection]
     * @return : org.apache.shiro.authz.AuthorizationInfo
     * @throws :可能抛出的异常;
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       // logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        Object obj1 = principalCollection.getPrimaryPrincipal();
        Object obj = super.getAvailablePrincipal(principalCollection);
        //到数据库查是否有此对象
       /* User user1=userDao.selectByLoginName(user.getLoginName());// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        if(user!=null){
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //查询用户角色的集合信息；


        }*/




       /* User user=userDao.findByName(loginName);// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        if(user!=null){
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //用户的角色集合
            info.setRoles(user.getRolesName());
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            List<Role> roleList=user.getRoleList();
            for (Role role : roleList) {
                info.addStringPermissions(role.getPermissionsName());
            }
            // 或者按下面这样添加
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
//            simpleAuthorInfo.addRole("admin");
            //添加权限
//            simpleAuthorInfo.addStringPermission("admin:manage");
//            logger.info("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");
            return info;
        }*/
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        User user = userDao.selectByLoginName(token.getUsername());
        String ss = getName();
        if(user != null){
            if(user.getDisabled() == 1){
                throw new LockedAccountException("msg:该帐号已禁止登录");
            }else{
                //doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
                SimpleAuthenticationInfo info = null;
                info =  new SimpleAuthenticationInfo(user.getLoginName(), user.getPass(), getName());//user是从数据库查出来的用户对象，密码是数据库密码，shrio用跟token进行比对；
                SecurityUtils.getSubject().isPermitted(user.getLoginName());//去调用doGetAuthorizationInfo，获取访问权限信息；
                return info;
            }
        }else{
            throw new UnknownAccountException("msg:该帐号不存在");
        }
        //return null;
       /* logger.info("验证当前Subject时获取到token为：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
*/
    }

    public void removeUserAuthorizationInfoCache(String username) {
        SimplePrincipalCollection pc = new SimplePrincipalCollection();
        pc.add(username, super.getName());
        super.clearCachedAuthorizationInfo(pc);
    }


}
