package com.avvilenn.student.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "student-orders")
public class StudentOrders
{
    @XmlElement(name = "student-order", required = true)
    private List<StudentOrder> studentOrders;

    public List<StudentOrder> getStudentOrders() {
        return studentOrders;
    }

    public void setStudentOrders(List<StudentOrder> studentOrders) {
        this.studentOrders = studentOrders;
    }
}
