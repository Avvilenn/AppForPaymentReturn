package com.avvilenn.student.dao;


import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.exceptions.OrderException;

import java.util.List;

public interface LogInDaoInterface {
    Long addPersonLogIn (PersonAdult person) throws OrderException;
    void updatePersonLogIn (PersonAdult person) throws OrderException;
    PersonAdult getPersonLogIn (Long id) throws  OrderException;
    List <PersonAdult> getAllPersons () throws  OrderException;
    void deleteAllPersons () throws OrderException;
    void deleteOneLogIn (Long id) throws OrderException;
}
