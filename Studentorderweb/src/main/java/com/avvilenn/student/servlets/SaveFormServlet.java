package com.avvilenn.student.servlets;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.domain.PersonChild;
import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.OrderManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SaveFormServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PersonAdult husbant = new PersonAdult();
        PersonAdult wife = new PersonAdult();
        PersonChild child = new PersonChild();
        StudentOrder order = new StudentOrder();
        OrderManager manager = OrderManager.getInstance();

        String email = req.getParameter("email");
        String husband_surName=  req.getParameter("husband_surName");
        String  husband_givenName = req.getParameter("husband_givenName");
        String husband_patronymic  = req.getParameter("husband_patronymic");
        String husband_dateOfBirth  = req.getParameter("husband_dateOfBirth");
        String husband_passportSeria  = req.getParameter("husband_passportSeria");
        String husband_passportNumber  = req.getParameter("husband_passportNumber");
        String husband_passportDateIssue  = req.getParameter("husband_passportDateIssue");
        String husband_passportDateExpire  = req.getParameter("husband_passportDateExpire");
        String wife_surName  = req.getParameter("wife_surName");
        String wife_givenName  = req.getParameter("wife_givenName");
        String wife_patronymic  = req.getParameter("wife_patronymic");
        String wife_dateOfBirth  = req.getParameter("wife_dateOfBirth");
        String wife_passportSeria  = req.getParameter("wife_passportSeria");
        String wife_passportNumber  = req.getParameter("wife_passportNumber");
        String wife_passportDateIssue  = req.getParameter("wife_passportDateIssue");
        String wife_passportDateExpire  = req.getParameter("wife_passportDateExpire");
        String surName = req.getParameter("surName");
        String givenName = req.getParameter("givenName");
        String patronymic = req.getParameter("patronymic");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String birthDocument = req.getParameter("birthDocument");


        try {
            husbant.setSurName(husband_surName);
            husbant.setGivenName(husband_givenName);
            husbant.setPatronymic(husband_patronymic);
            husbant.setPassportNumber(husband_passportNumber);
            husbant.setPassportSeria(husband_passportSeria);
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            husbant.setPassportDateIssue(formatter.parse(husband_passportDateIssue));
            husbant.setPassportDateExpire(formatter.parse(husband_passportDateExpire));
            husbant.setDateOfBirth(formatter.parse(husband_dateOfBirth));


            wife.setSurName(wife_surName);
            wife.setGivenName(wife_givenName);
            wife.setPatronymic(wife_patronymic);
            wife.setPassportNumber(wife_passportNumber);
            wife.setPassportSeria(wife_passportSeria);
            wife.setPassportDateIssue(formatter.parse(wife_passportDateIssue));
            wife.setPassportDateExpire(formatter.parse(wife_passportDateExpire));
            wife.setDateOfBirth(formatter.parse(wife_dateOfBirth));

            order.setWife(wife);
            order.setHusband(husbant);
            order.setEmail(email);

            child.setSurName(surName);
            child.setGivenName(givenName);
            child.setPatronymic(patronymic);
            child.setDateOfBirth(formatter.parse(dateOfBirth));
            child.setBirthDocument(birthDocument);

            List<PersonChild> children = new ArrayList<PersonChild>();
            children.add(child);
            order.setChildren(children);

            Long id = manager.addOrder(order);
            req.setAttribute("ID", id);
            getServletContext().getRequestDispatcher("/SavedSucced.jsp").forward(req, resp);


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }


}
