package com.avvilenn.student.dao;

import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.OrderException;


public interface UpdateForCheckers {
    void updateGRN (StudentOrders orders) throws OrderException;
    void updateZAGS (StudentOrders orders) throws OrderException;
    void updateStudent (StudentOrders orders) throws OrderException;
    boolean getGRNanswer (StudentOrder order)  throws OrderException;
    boolean getZAGSanswer (StudentOrder order)  throws OrderException;
    boolean getStudentAnswer (StudentOrder order) throws OrderException;
}
