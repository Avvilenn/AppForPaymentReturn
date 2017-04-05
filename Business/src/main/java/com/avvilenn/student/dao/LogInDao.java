package com.avvilenn.student.dao;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.exceptions.OrderException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogInDao implements  LogInDaoInterface{

    private Connection getConnection() throws Exception {
        return ConnectionBuilder.getConnection();
    }


    public Long addPersonLogIn(PersonAdult person) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "INSERT INTO log_in (email, password) VALUES (?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql, new String[]{
                        "log_id"
                });

                stmt.setString(1, person.getEmail());
                stmt.setString(2, person.getPassword());

                stmt.executeUpdate();
                ResultSet gk = stmt.getGeneratedKeys();
                Long savedId = 0L;
                if (gk.next()) {
                    savedId = gk.getLong(1);
                }
                person.setPersonId(savedId);

                stmt.close();

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

    public void updatePersonLogIn(PersonAdult person) throws OrderException {

        try {
            Connection con = getConnection();
            try {
                String sql = "UPDATE log_in SET email=?, password=? WHERE log_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, person.getEmail());
                stmt.setString(2, person.getPassword());
                stmt.setLong(3, person.getPersonId());
             stmt.executeUpdate();

                con.commit();
                stmt.close();

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

    public PersonAdult getPersonLogIn(Long id) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM log_in WHERE log_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                PersonAdult person = new PersonAdult();
                while (rs.next()) {
                   person.setEmail(rs.getString("email"));
                   person.setPassword(rs.getString("password"));
                }

                rs.close();
                stmt.close();
                return person;
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

    public PersonAdult getPerson (String email, String password) throws OrderException {
        try {
            Connection con = getConnection();

            try {
                String sql = "SELECT * FROM log_in WHERE email=? and password=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                PersonAdult person = new PersonAdult();
                while (rs.next()) {
                    person.setPersonId(rs.getLong("log_id"));
                    person.setEmail(rs.getString("email"));
                    person.setPassword(rs.getString("password"));
                }

                rs.close();
                stmt.close();
                return person;
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

    public List<PersonAdult> getAllPersons() throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "SELECT * FROM log_in";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                List<PersonAdult> personAdults = new ArrayList<PersonAdult>();
                while (rs.next()) {
                    PersonAdult person = new PersonAdult();

                    person.setEmail(rs.getString("password "));
                    person.setPassword(rs.getString("email"));
                    person.setPersonId(rs.getLong("log_id"));

                    personAdults.add(person);

                }

                rs.close();
                stmt.close();
                return personAdults;
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

    public void deleteAllPersons() throws OrderException {
        try {
            Connection con = getConnection();
            try {
                String sql = "DELETE all FROM log_in";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.executeUpdate();

                stmt.close();

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

    public void deleteOneLogIn(Long id) throws OrderException {

        try {
            Connection con = getConnection();
            try {
                String sql = "DELETE all FROM log_in WHERE log_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setLong(1, id);
                stmt.executeUpdate();

                stmt.close();

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
