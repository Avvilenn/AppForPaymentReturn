package com.avvilenn.student.dao;


import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GlobalDaoFactory {
    private static OrderDao orderDao;
    private static LogInDao logInDao;
    private static CheckerDao checkerDao;

    public synchronized static void createAllDao() throws Exception {
        PropertyResourceBundle p = (PropertyResourceBundle) ResourceBundle.getBundle("DaoProperties");
        String orderDaoStr = p.getString("OrderDao");
        orderDao = (OrderDao) Class.forName(orderDaoStr).newInstance();
        String LogInDaoStr = p.getString("logInDao");
        logInDao = (LogInDao) Class.forName(orderDaoStr).newInstance();
        String Str = p.getString("checkerDao");
        checkerDao = (CheckerDao) Class.forName(Str).newInstance();
    }

    public synchronized static OrderDao getOrderDao() {
        if (orderDao==null) {
            try {
                createAllDao();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return orderDao;
    }

    public synchronized static LogInDao getLogInDao() {
        if (logInDao==null) {
            try {
                createAllDao();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return logInDao;
    }

    public synchronized static CheckerDao getCheckerDao() {
        if (checkerDao==null) {
            try {
                createAllDao();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return checkerDao;
    }
}
