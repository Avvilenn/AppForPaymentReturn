package com.avvilenn.student.managers;


import com.avvilenn.student.dao.GlobalDaoFactory;
import com.avvilenn.student.dao.LogInDao;
import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.exceptions.OrderException;

import java.util.List;

public class LogInManager {
    private static LogInManager ourInstance = new LogInManager();
    private LogInDao dao = GlobalDaoFactory.getLogInDao();

    public static LogInManager getInstance() {
        return ourInstance;
    }

    private LogInManager() {
    }

    public  Long addPersonLogIn (PersonAdult person) throws BusinessException {
        try {
            Long id = dao.addPersonLogIn(person);
            return id;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    public void updatePersonLogIn (PersonAdult person) throws BusinessException {

        try {
            dao.updatePersonLogIn(person);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }
    public PersonAdult getPersonLogIn (Long id) throws BusinessException {

        try {
           PersonAdult person =  dao.getPersonLogIn(id);
            return person;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }
    public List<PersonAdult> getAllPersons () throws BusinessException {

        try {
            List <PersonAdult> personAdultList = dao.getAllPersons();
            return personAdultList;
        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }
    public void deleteAllPersons ()  throws BusinessException {

        try {
           dao.deleteAllPersons();

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }
    public void deleteOneLogIn (Long id)  throws BusinessException {

        try {
            dao.deleteOneLogIn(id);

        } catch (OrderException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }
}
