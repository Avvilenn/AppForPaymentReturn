package com.avvilenn.student.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class StudentOrder implements Serializable
{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "husband", required = true)
    private PersonAdult husband;
    @XmlElement(name = "wife", required = true)
    private PersonAdult wife;
    @XmlElementWrapper(name="children")
    @XmlElement(name = "child")
    private List<PersonChild> children;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public boolean isGrnAnswer() {
        return grnAnswer;
    }

    public void setGrnAnswer(boolean grnAnswer) {
        this.grnAnswer = grnAnswer;
    }

    @XmlElement (name = "grnAnswer")
    private boolean grnAnswer;

    @XmlElement (name = "zagsAnswer")
    private boolean zagsAnswer;

    @XmlElement (name = "studentAnswer")
    private boolean studentAnswer;

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    private  String verification;


    public boolean isZagsAnswer() {
        return zagsAnswer;
    }

    public void setZagsAnswer(boolean zagsAnswer) {
        this.zagsAnswer = zagsAnswer;
    }

    public boolean isStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(boolean studentAnswer) {
        this.studentAnswer = studentAnswer;
    }




    public StudentOrder() {
    }

    public StudentOrder(PersonAdult husband, PersonAdult wife, List<PersonChild> children) {
        this.husband = husband;
        this.wife = wife;
        this.children = children;
    }

    public PersonAdult getHusband() {
        return husband;
    }

    public PersonAdult getWife() {
        return wife;
    }

    public void setHusband(PersonAdult husband) {
        this.husband = husband;
    }

    public void setWife(PersonAdult wife) {
        this.wife = wife;
    }

    public List<PersonChild> getChildren() {
        return children;
    }

    public void setChildren(List<PersonChild> children) {
        this.children = children;
    }
}
