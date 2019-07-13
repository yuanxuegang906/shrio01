package com.qf.md5;

import org.apache.shiro.crypto.hash.Md5Hash;

/*
 * author:袁学港
 * Date:2019/7/11 15:56
 * info:
 * */
public class Md5Test {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123","qf",2);
        System.out.println(md5Hash.toString());
    }
}
