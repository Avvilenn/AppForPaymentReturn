package com.avvilenn.student.servlets;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.LogInManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonLoginServlet extends HttpServlet {

    private LogInManager manager;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PersonAdult person;
        try {
            person = manager.getPerson(login, password);
            if (person!= null){
                req.getSession().setAttribute("email", login);
            }
            resp.sendRedirect(req.getContextPath() + "/form.jsp");
        } catch (BusinessException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void init() throws ServletException {
        super.init();
        manager = LogInManager.getInstance();
    }
}
