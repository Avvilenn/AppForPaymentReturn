package com.avvilenn.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class ConnectionBuilder {
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            PropertyResourceBundle p = (PropertyResourceBundle) ResourceBundle.getBundle("DaoProperties");
            Class.forName(p.getString("MysqlDriver"));
            url = p.getString("MysqlConnectionUrl");
            user = p.getString("MySQLuser");
            password = p.getString("MySQLPassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
