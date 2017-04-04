package com.avvilenn.student.managers;

import com.avvilenn.student.checkers.BasicChecker;
import com.avvilenn.student.dao.GlobalDaoFactory;
import com.avvilenn.student.dao.OrderDao;
import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.exceptions.OrderException;

public class OrderManager {
    private static OrderManager ourInstance = new OrderManager();
    private OrderDao dao = GlobalDaoFactory.getOrderDao();

    public static OrderManager getInstance() {
        return ourInstance;
    }

    private OrderManager() {
    }

    public Long addOrder (StudentOrder order) throws BusinessException {
        try {
            Long id = dao.addOrder(order);
            if (id%1==0){
                TriggerForCheckers();
            }
            return id;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public void updateOrder (StudentOrder order) throws BusinessException {
        try {
            dao.updateOrder(order);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public StudentOrder getOrder (Long id) throws BusinessException {
        try {
            StudentOrder order = dao.getOrder(id);
            return order;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public StudentOrders getAllOrders ()throws BusinessException {
        try {
            StudentOrders orders = dao.getAllOrders();
            return orders;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public void deleteAll () throws BusinessException {
        try {
            dao.deleteAll();

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public void deleteOne (Long id) throws BusinessException {
        try {
            dao.deleteOne(id);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public StudentOrders getForCheck () throws BusinessException {
        try {
            StudentOrders orders = dao.getForCheck();
            return orders;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public StudentOrders getForEmail (String email) throws BusinessException {
        try {
            StudentOrders orders = dao.getForEmail(email);
            return orders;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    private void TriggerForCheckers() {
        BasicChecker checker = new BasicChecker();
        checker.start();
    }


}
