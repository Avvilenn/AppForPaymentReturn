package com.avvilenn.student.servlets;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.LogInManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SavePersonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PersonAdult personAdult = new PersonAdult();
        
        personAdult.setEmail(email);
        personAdult.setPassword(password);
        LogInManager manager = LogInManager.getInstance();
        try {
            manager.addPersonLogIn(personAdult);
            req.getSession().setAttribute("email", email);
            resp.sendRedirect(req.getContextPath() + "/form.jsp");

        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}
