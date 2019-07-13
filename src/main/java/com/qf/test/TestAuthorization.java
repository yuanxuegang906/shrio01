package com.qf.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/*
 * author:袁学港
 * Date:2019/7/12 11:08
 * info:
 * */
public class TestAuthorization {
    @Test
    public void test1(){
        Factory<SecurityManager> factory =  new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","123");
        try {
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()) {
                System.out.println(subject.getPrincipal() + "登陆成功");
                System.out.println(subject.isPermitted("user:add"));
            }
        }catch (AuthenticationException e){
            System.out.println("登录失败");
        }
    }
}
