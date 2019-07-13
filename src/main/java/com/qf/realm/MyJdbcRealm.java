package com.qf.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;

/*
 * author:袁学港
 * Date:2019/7/11 20:40
 * info:
 * */
public class MyJdbcRealm extends JdbcRealm {
    public MyJdbcRealm() {
        setSaltStyle(JdbcRealm.SaltStyle.COLUMN);
    }
}
