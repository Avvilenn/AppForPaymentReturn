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

public class OrderDao implements OrderDaoInterface{

    private Connection getConnection() throws Exception {
        return ConnectionBuilder.getConnection();
    }


    public Long addOrder(StudentOrder order) throws OrderException {

        try {
            Connection con = getConnection();
            con.setAutoCommit(false);
            try {
                String sql = "INSERT INTO orders (email, husband_surName,  husband_givenName, " +
                        "husband_patronymic, husband_dateOfBirth, husband_passportSeria, husband_passportNumber," +
                        " husband_passportDateIssue, husband_passportDateExpire, wife_surName, wife_givenName," +
                        " wife_patronymic, wife_dateOfBirth, wife_passportSeria, wife_passportNumber, wife_passportDateIssue," +
                        " wife_passportDateExpire ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql, new String[]{
                        "orders_id"
                });

                stmt.setString(1, order.getEmail());
                stmt.setString(2, order.getHusband().getSurName());
                stmt.setString(3, order.getHusband().getGivenName());
                stmt.setString(4, order.getHusband().getPatronymic());
                stmt.setDate(5, new java.sql.Date(order.getHusband().getDateOfBirth().getTime()));
                stmt.setString(6, order.getHusband().getPassportSeria());
                stmt.setString(7, order.getHusband().getPassportNumber());
                stmt.setDate(8, new java.sql.Date(order.getHusband().getPassportDateIssue().getTime()));
                stmt.setDate(9, new java.sql.Date(order.getHusband().getPassportDateExpire().getTime()) );
                stmt.setString(10, order.getWife().getSurName());
                stmt.setString(11, order.getWife().getGivenName());
                stmt.setString(12, order.getWife().getPatronymic());
                stmt.setDate(13, new java.sql.Date(order.getWife().getDateOfBirth().getTime()));
                stmt.setString(14, order.getWife().getPassportSeria());
                stmt.setString(15, order.getWife().getPassportNumber());
                stmt.setDate(16, new java.sql.Date(order.getWife().getPassportDateIssue().getTime()));
                stmt.setDate(17, new java.sql.Date(order.getWife().getPassportDateExpire().getTime()) );
                stmt.executeUpdate();
                ResultSet gk = stmt.getGeneratedKeys();
                Long savedId = 0L;
                if (gk.next()) {
                    savedId = gk.getLong(1);
                }
                order.setId(savedId);


                String sql2 = "INSERT INTO children (order_id, surName, givenName, patronymic, dateOfBirth," +
                        "birthDocument) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                for (PersonChild child: order.getChildren()) {
                    stmt2.setLong(1, savedId);
                    stmt2.setString(2, child.getSurName());
                    stmt2.setString(3, child.getGivenName());
                    stmt2.setString(4, child.getPatronymic());
                    stmt2.setDate(5, new java.sql.Date(child.getDateOfBirth().getTime()));
                    stmt2.setString(6, child.getBirthDocument());
                    stmt2.executeUpdate();
                }
                con.commit();
                stmt.close();
                stmt2.close();
                return savedId;
            } catch (SQLException e) {
                e.printStackTrace();
                con.rollback();
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

    public void updateOrder(StudentOrder order) throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "UPDATE orders SET email=?, husband_surName=?,  husband_givenName=?, " +
                        "husband_patronymic=?, husband_dateOfBirth=?, husband_passportSeria=?, husband_passportNumber=?," +
                        " husband_passportDateIssue=?, husband_passportDateExpire=?, wife_surName=?, wife_givenName=?," +
                        " wife_patronymic=?, wife_dateOfBirth=?, wife_passportSeria=?, wife_passportNumber=?, wife_passportDateIssue=?," +
                        " wife_passportDateExpire=? WHERE orders_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(18, order.getId());
                stmt.setString(1, order.getEmail());
                stmt.setString(2, order.getHusband().getSurName());
                stmt.setString(3, order.getHusband().getGivenName());
                stmt.setString(4, order.getHusband().getPatronymic());
                stmt.setDate(5, new java.sql.Date(order.getHusband().getDateOfBirth().getTime()));
                stmt.setString(6, order.getHusband().getPassportSeria());
                stmt.setString(7, order.getHusband().getPassportNumber());
                stmt.setDate(8, new java.sql.Date(order.getHusband().getPassportDateIssue().getTime()));
                stmt.setDate(9, new java.sql.Date(order.getHusband().getPassportDateExpire().getTime()) );
                stmt.setString(10, order.getWife().getSurName());
                stmt.setString(11, order.getWife().getGivenName());
                stmt.setString(12, order.getWife().getPatronymic());
                stmt.setDate(13, new java.sql.Date(order.getWife().getDateOfBirth().getTime()));
                stmt.setString(14, order.getWife().getPassportSeria());
                stmt.setString(15, order.getWife().getPassportNumber());
                stmt.setDate(16, new java.sql.Date(order.getWife().getPassportDateIssue().getTime()));
                stmt.setDate(17, new java.sql.Date(order.getWife().getPassportDateExpire().getTime()) );
                stmt.executeUpdate();

                String sql2 = "UPDATE children SET surName=?, givenName=?, patronymic=?, dateOfBirth=?," +
                        "birthDocument=? WHERE orders_id = ?";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                for (PersonChild child: order.getChildren()) {
                    stmt2.setLong(6, order.getId());
                    stmt2.setString(1, child.getSurName());
                    stmt2.setString(2, child.getGivenName());
                    stmt2.setString(3, child.getPatronymic());
                    stmt2.setDate(4, new java.sql.Date(child.getDateOfBirth().getTime()));
                    stmt2.setString(5, child.getBirthDocument());
                    stmt2.executeUpdate();
                }
                con.commit();
                stmt.close();
                stmt2.close();

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

    public StudentOrder getOrder(Long id) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM orders WHERE orders_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                StudentOrder order = new StudentOrder();
                while (rs.next()) {
                     order.setId(rs.getLong("orders_id"));
                    PersonAdult husbant = new PersonAdult();
                    PersonAdult wife = new PersonAdult();
                    husbant.setSurName(rs.getString("husband_surName"));
                    husbant.setGivenName(rs.getString("husband_givenName"));
                    husbant.setPatronymic(rs.getString("husband_patronymic"));
                    husbant.setDateOfBirth(rs.getDate("husband_dateOfBirth"));
                    husbant.setPassportNumber(rs.getString("husband_passportNumber"));
                    husbant.setPassportSeria(rs.getString("husband_passportSeria"));
                    husbant.setPassportDateIssue(rs.getDate("husband_passportDateIssue"));
                    husbant.setPassportDateExpire(rs.getDate("husband_passportDateExpire"));
                    order.setHusband(husbant);
                    wife.setSurName(rs.getString("wife_surName"));
                    wife.setGivenName(rs.getString("wife_givenName"));
                    wife.setPatronymic(rs.getString("wife_patronymic"));
                    wife.setDateOfBirth(rs.getDate("wife_dateOfBirth"));
                    wife.setPassportNumber(rs.getString("wife_passportNumber"));
                    wife.setPassportSeria(rs.getString("wife_passportSeria"));
                    wife.setPassportDateIssue(rs.getDate("wife_passportDateIssue"));
                    wife.setPassportDateExpire(rs.getDate("wife_passportDateExpire"));
                    order.setWife(wife);
                    String sql1 = "SELECT * FROM children WHERE order_id=?";
                    PreparedStatement stmt2 = con.prepareStatement(sql1);
                    stmt2.setLong(1, order.getId());
                    ResultSet rs2 = stmt2.executeQuery();
                    List <PersonChild> children = new ArrayList<PersonChild>();
                    while (rs2.next()) {
                        PersonChild child = new PersonChild();
                        child.setSurName(rs2.getString("surName"));
                        child.setGivenName(rs2.getString("givenName"));
                        child.setPatronymic(rs2.getString("patronymic"));
                        child.setDateOfBirth(rs2.getDate("dateOfBirth"));
                        child.setBirthDocument(rs2.getString("birthDocument"));
                        children.add(child);
                    }
                    order.setChildren(children);
                }

                rs.close();
                stmt.close();
                return order;
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

    public StudentOrders getAllOrders() throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "SELECT * FROM orders";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                StudentOrders studentOrders = null;
                List<StudentOrder> orderList = new ArrayList<StudentOrder>();
                while (rs.next()) {
                    StudentOrder order = new StudentOrder();
                    order.setId(rs.getLong("orders_id"));
                    PersonAdult husbant = new PersonAdult();
                    PersonAdult wife = new PersonAdult();
                    husbant.setSurName(rs.getString("husband_surName"));
                    husbant.setGivenName(rs.getString("husband_givenName"));
                    husbant.setPatronymic(rs.getString("husband_patronymic"));
                    husbant.setDateOfBirth(rs.getDate("husband_dateOfBirth"));
                    husbant.setPassportNumber(rs.getString("husband_passportNumber"));
                    husbant.setPassportSeria(rs.getString("husband_passportSeria"));
                    husbant.setPassportDateIssue(rs.getDate("husband_passportDateIssue"));
                    husbant.setPassportDateExpire(rs.getDate("husband_passportDateExpire"));
                    order.setHusband(husbant);
                    wife.setSurName(rs.getString("wife_surName"));
                    wife.setGivenName(rs.getString("wife_givenName"));
                    wife.setPatronymic(rs.getString("wife_patronymic"));
                    wife.setDateOfBirth(rs.getDate("wife_dateOfBirth"));
                    wife.setPassportNumber(rs.getString("wife_passportNumber"));
                    wife.setPassportSeria(rs.getString("wife_passportSeria"));
                    wife.setPassportDateIssue(rs.getDate("wife_passportDateIssue"));
                    wife.setPassportDateExpire(rs.getDate("wife_passportDateExpire"));
                    order.setWife(wife);
                    String sql1 = "SELECT * FROM children WHERE order_id=?";
                    PreparedStatement stmt2 = con.prepareStatement(sql1);
                    stmt2.setLong(1, order.getId());
                    ResultSet rs2 = stmt2.executeQuery();
                    List <PersonChild> children = new ArrayList<PersonChild>();
                    while (rs2.next()) {
                        PersonChild child = new PersonChild();
                        child.setSurName(rs2.getString("surName"));
                        child.setGivenName(rs2.getString("givenName"));
                        child.setPatronymic(rs2.getString("patronymic"));
                        child.setDateOfBirth(rs2.getDate("dateOfBirth"));
                        child.setBirthDocument(rs2.getString("birthDocument"));
                        children.add(child);
                    }
                    order.setChildren(children);
                    orderList.add(order);

                }
                studentOrders.setStudentOrders(orderList);
                rs.close();
                stmt.close();
                return studentOrders;
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

    public void deleteAll() throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "DELETE all FROM orders";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.executeUpdate();
                String sql2 = "DELETE all FROM children";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                stmt2.executeUpdate();
                stmt.close();
                stmt2.close();
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

    public void deleteOne(Long id) throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "DELETE all FROM orders WHERE orders_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, id);
                stmt.executeUpdate();
                String sql2 = "DELETE all FROM children WHERE orders_id=?";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                stmt2.setLong(1, id);
                stmt2.executeUpdate();
                stmt.close();
                stmt2.close();
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

    public StudentOrders getForCheck() throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "SELECT * FROM orders WHERE verification =null";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                StudentOrders studentOrders = null;
                List<StudentOrder> orderList = new ArrayList<StudentOrder>();
                while (rs.next()) {
                    StudentOrder order = new StudentOrder();
                    order.setId(rs.getLong("orders_id"));
                    PersonAdult husbant = new PersonAdult();
                    PersonAdult wife = new PersonAdult();
                    husbant.setSurName(rs.getString("husband_surName"));
                    husbant.setGivenName(rs.getString("husband_givenName"));
                    husbant.setPatronymic(rs.getString("husband_patronymic"));
                    husbant.setDateOfBirth(rs.getDate("husband_dateOfBirth"));
                    husbant.setPassportNumber(rs.getString("husband_passportNumber"));
                    husbant.setPassportSeria(rs.getString("husband_passportSeria"));
                    husbant.setPassportDateIssue(rs.getDate("husband_passportDateIssue"));
                    husbant.setPassportDateExpire(rs.getDate("husband_passportDateExpire"));
                    order.setHusband(husbant);
                    wife.setSurName(rs.getString("wife_surName"));
                    wife.setGivenName(rs.getString("wife_givenName"));
                    wife.setPatronymic(rs.getString("wife_patronymic"));
                    wife.setDateOfBirth(rs.getDate("wife_dateOfBirth"));
                    wife.setPassportNumber(rs.getString("wife_passportNumber"));
                    wife.setPassportSeria(rs.getString("wife_passportSeria"));
                    wife.setPassportDateIssue(rs.getDate("wife_passportDateIssue"));
                    wife.setPassportDateExpire(rs.getDate("wife_passportDateExpire"));
                    order.setWife(wife);
                    String sql1 = "SELECT * FROM children WHERE order_id=?";
                    PreparedStatement stmt2 = con.prepareStatement(sql1);
                    stmt2.setLong(1, order.getId());
                    ResultSet rs2 = stmt2.executeQuery();
                    List <PersonChild> children = new ArrayList<PersonChild>();
                    while (rs2.next()) {
                        PersonChild child = new PersonChild();
                        child.setSurName(rs2.getString("surName"));
                        child.setGivenName(rs2.getString("givenName"));
                        child.setPatronymic(rs2.getString("patronymic"));
                        child.setDateOfBirth(rs2.getDate("dateOfBirth"));
                        child.setBirthDocument(rs2.getString("birthDocument"));
                        children.add(child);
                    }
                    order.setChildren(children);
                    orderList.add(order);

                }
                studentOrders.setStudentOrders(orderList);
                rs.close();
                stmt.close();
                return studentOrders;
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

    public StudentOrders getForEmail(String email) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM orders WHERE email=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                StudentOrders studentOrders = null;
                List<StudentOrder> orderList = new ArrayList<StudentOrder>();
                while (rs.next()) {
                    StudentOrder order = new StudentOrder();
                    order.setId(rs.getLong("orders_id"));
                    PersonAdult husbant = new PersonAdult();
                    PersonAdult wife = new PersonAdult();
                    husbant.setSurName(rs.getString("husband_surName"));
                    husbant.setGivenName(rs.getString("husband_givenName"));
                    husbant.setPatronymic(rs.getString("husband_patronymic"));
                    husbant.setDateOfBirth(rs.getDate("husband_dateOfBirth"));
                    husbant.setPassportNumber(rs.getString("husband_passportNumber"));
                    husbant.setPassportSeria(rs.getString("husband_passportSeria"));
                    husbant.setPassportDateIssue(rs.getDate("husband_passportDateIssue"));
                    husbant.setPassportDateExpire(rs.getDate("husband_passportDateExpire"));
                    order.setHusband(husbant);
                    wife.setSurName(rs.getString("wife_surName"));
                    wife.setGivenName(rs.getString("wife_givenName"));
                    wife.setPatronymic(rs.getString("wife_patronymic"));
                    wife.setDateOfBirth(rs.getDate("wife_dateOfBirth"));
                    wife.setPassportNumber(rs.getString("wife_passportNumber"));
                    wife.setPassportSeria(rs.getString("wife_passportSeria"));
                    wife.setPassportDateIssue(rs.getDate("wife_passportDateIssue"));
                    wife.setPassportDateExpire(rs.getDate("wife_passportDateExpire"));
                    order.setWife(wife);
                    String sql1 = "SELECT * FROM children WHERE order_id=?";
                    PreparedStatement stmt2 = con.prepareStatement(sql1);
                    stmt2.setLong(1, order.getId());
                    ResultSet rs2 = stmt2.executeQuery();
                    List <PersonChild> children = new ArrayList<PersonChild>();
                    while (rs2.next()) {
                        PersonChild child = new PersonChild();
                        child.setSurName(rs2.getString("surName"));
                        child.setGivenName(rs2.getString("givenName"));
                        child.setPatronymic(rs2.getString("patronymic"));
                        child.setDateOfBirth(rs2.getDate("dateOfBirth"));
                        child.setBirthDocument(rs2.getString("birthDocument"));
                        children.add(child);
                    }
                    order.setChildren(children);
                    orderList.add(order);

                }
                studentOrders.setStudentOrders(orderList);
                rs.close();
                stmt.close();
                return studentOrders;
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
