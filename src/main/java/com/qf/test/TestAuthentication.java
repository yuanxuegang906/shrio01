package com.qf.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/*
 * author:袁学港
 * Date:2019/7/11 10:03
 * info:
 * */
public class TestAuthentication {
    @Test
    public void test1(){
        Factory<SecurityManager> factory =  new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","123");

       try {
           subject.login(usernamePasswordToken);
           boolean authenticated = subject.isAuthenticated();
           if (authenticated) {
               System.out.println("登录成功");
               Object principal = subject.getPrincipal();
               System.out.println("principal = " + principal);
           }

       }catch (UnknownAccountException e){
           System.out.println("未知账户");
       }catch (IncorrectCredentialsException e){
           System.out.println("密码错误");
       } catch (AuthenticationException e) {
           System.out.println(e.getMessage());
       }

    }
}
