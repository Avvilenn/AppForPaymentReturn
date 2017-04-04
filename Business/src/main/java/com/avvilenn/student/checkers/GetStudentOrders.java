package com.avvilenn.student.checkers;


import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.OrderManager;

public class GetStudentOrders {
    private static GetStudentOrders ourInstance = new GetStudentOrders();

    public static GetStudentOrders getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(GetStudentOrders ourInstance) {
        GetStudentOrders.ourInstance = ourInstance;
    }

    public static StudentOrders getOrders() {
        return orders;
    }

    public static void setOrders() {
        try {
            orders = OrderManager.getInstance().getForCheck();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }

    private static StudentOrders orders;

    public static GetStudentOrders getInstance() {
        return ourInstance;
    }

    private GetStudentOrders() {
    }

}
