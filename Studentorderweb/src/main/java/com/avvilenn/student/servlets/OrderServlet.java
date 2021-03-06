package com.avvilenn.student.servlets;


import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.OrderManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends HttpServlet {
    private OrderManager manager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            StudentOrders orders = manager.getAllOrders();
            List <StudentOrder> orderList = orders.getStudentOrders();
            req.setAttribute("ORDERS", orderList);
            getServletContext().getRequestDispatcher("/orderList.jsp").forward(req, resp);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        manager = OrderManager.getInstance();
    }
}
