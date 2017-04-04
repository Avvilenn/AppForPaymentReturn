package com.avvilenn.student.servlets;


import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.LogInManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonDeleteServlet extends HttpServlet
{
    private LogInManager manager;

    @Override
    public void init() throws ServletException {
        super.init();
        manager = LogInManager.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personId = req.getParameter("personId");
        try {
            manager.deleteOneLogIn(Long.parseLong(personId));
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/persons");
    }
}

