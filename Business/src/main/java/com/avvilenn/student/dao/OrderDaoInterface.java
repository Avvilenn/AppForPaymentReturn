package com.avvilenn.student.dao;

import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.OrderException;
import com.sun.org.apache.xpath.internal.operations.Or;


public interface OrderDaoInterface {
    Long addOrder (StudentOrder order) throws OrderException;
    void updateOrder (StudentOrder order) throws OrderException;
    StudentOrder getOrder (Long id) throws OrderException;
    StudentOrders getAllOrders () throws OrderException;
    void deleteAll () throws OrderException;
    void deleteOne (Long id) throws OrderException;
    StudentOrders getForCheck () throws  OrderException;
    StudentOrders getForEmail (String email) throws OrderException;

}
