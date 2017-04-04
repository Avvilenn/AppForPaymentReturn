package com.avvilenn.student.dao;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.domain.PersonChild;
import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.OrderException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckerDao implements  UpdateForCheckers{

    private Connection getConnection() throws Exception {
        return ConnectionBuilder.getConnection();
    }

    public void updateGRN(StudentOrders orders) throws OrderException {
        try {
            Connection con = getConnection();
            for ( StudentOrder order: orders.getStudentOrders()) {
                try {

                    String sql = "UPDATE orders SET grnAnswer=? WHERE orders_id = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setLong(2, order.getId());
                    stmt.setBoolean(1, order.isGrnAnswer());
                    con.commit();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    OrderException o = new OrderException("addOrderException", 1);
                    throw o;
                } finally {
                    con.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            OrderException o = new OrderException("addOrderException", 1);
            throw o;
        }

    }

    public void updateZAGS(StudentOrders orders) throws OrderException {
        try {
            Connection con = getConnection();
            for ( StudentOrder order: orders.getStudentOrders()) {
                try {

                    String sql = "UPDATE orders SET zagsAnswer=? WHERE orders_id = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setLong(2, order.getId());
                    stmt.setBoolean(1, order.isZagsAnswer());
                    con.commit();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    OrderException o = new OrderException("addOrderException", 1);
                    throw o;
                } finally {
                    con.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            OrderException o = new OrderException("addOrderException", 1);
            throw o;
        }


    }

    public void updateStudent(StudentOrders orders) throws OrderException {
        try {
            Connection con = getConnection();
            for ( StudentOrder order: orders.getStudentOrders()) {
                try {

                    String sql = "UPDATE orders SET studentAnswer=? WHERE orders_id = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setLong(2, order.getId());
                    stmt.setBoolean(1, order.isStudentAnswer());
                    con.commit();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    OrderException o = new OrderException("addOrderException", 1);
                    throw o;
                } finally {
                    con.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            OrderException o = new OrderException("addOrderException", 1);
            throw o;
        }
    }

    public boolean getGRNanswer(StudentOrder order) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM orders WHERE orders_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, order.getId());
                ResultSet rs = stmt.executeQuery();
                Boolean answer = false;
                while (rs.next()) {
                    answer = rs.getBoolean("grnAnswer");
                    }
                rs.close();
                stmt.close();
                return answer;
            } catch (SQLException e) {
                e.printStackTrace();
                OrderException o = new OrderException("addOrderException", 1);
                throw o;
            } finally {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            OrderException o = new OrderException("addOrderException", 1);
            throw o;
        }

    }

    public boolean getZAGSanswer(StudentOrder order) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM orders WHERE orders_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, order.getId());
                ResultSet rs = stmt.executeQuery();
                Boolean answer = false;
                while (rs.next()) {
                    answer = rs.getBoolean("zagsAnswer");
                }
                rs.close();
                stmt.close();
                return answer;
            } catch (SQLException e) {
                e.printStackTrace();
                OrderException o = new OrderException("addOrderException", 1);
                throw o;
            } finally {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            OrderException o = new OrderException("addOrderException", 1);
            throw o;
        }

    }

    public boolean getStudentAnswer(StudentOrder order) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM orders WHERE orders_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, order.getId());
                ResultSet rs = stmt.executeQuery();
                Boolean answer = false;
                while (rs.next()) {
                    answer = rs.getBoolean("studentAnswer");
                }
                rs.close();
                stmt.close();
                return answer;
            } catch (SQLException e) {
                e.printStackTrace();
                OrderException o = new OrderException("addOrderException", 1);
                throw o;
            } finally {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            OrderException o = new OrderException("addOrderException", 1);
            throw o;
        }

    }
}
