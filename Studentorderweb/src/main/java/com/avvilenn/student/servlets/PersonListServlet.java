package com.avvilenn.student.servlets;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.LogInManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PersonListServlet extends HttpServlet {
    private List <PersonAdult> personList;
    private LogInManager manager;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            personList = manager.getAllPersons();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        req.setAttribute("Persons", personList);
         getServletContext().getRequestDispatcher("/persons.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        manager = LogInManager.getInstance();
    }
}
