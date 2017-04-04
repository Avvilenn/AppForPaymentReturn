package com.avvilenn.student.managers;

import com.avvilenn.student.dao.CheckerDao;
import com.avvilenn.student.dao.GlobalDaoFactory;
import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.exceptions.OrderException;

/**
 * Created by просто on 04.04.2017.
 */
public class CheckerManager {
    private static CheckerManager ourInstance = new CheckerManager();

    public static CheckerManager getInstance() {
        return ourInstance;
    }

    private CheckerManager() {
    }

    private CheckerDao dao = GlobalDaoFactory.getCheckerDao();

    public void updateGRN (StudentOrders orders) throws BusinessException {
        try {
            dao.updateGRN(orders);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public void updateZAGS (StudentOrders orders) throws BusinessException {
        try {
             dao.updateZAGS(orders);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public void updateStudent (StudentOrders orders) throws BusinessException {
        try {
            dao.updateStudent(orders);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public boolean getGRNanswer (StudentOrder order)  throws BusinessException {
        try {
            Boolean an = dao.getGRNanswer(order);
            return an;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public boolean getZAGSanswer (StudentOrder order)  throws BusinessException {
        try {
            Boolean an = dao.getZAGSanswer(order);
            return an;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public boolean getStudentAnswer (StudentOrder order) throws BusinessException {
        try {
            Boolean an = dao.getStudentAnswer(order);
            return an;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
}
