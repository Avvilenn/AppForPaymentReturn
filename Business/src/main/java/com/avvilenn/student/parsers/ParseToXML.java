package com.avvilenn.student.parsers;


import com.avvilenn.student.domain.StudentOrders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ParseToXML {
    private static ParseToXML ourInstance = new ParseToXML();

    public static ParseToXML getInstance() {
        return ourInstance;
    }

    private ParseToXML() {
    }

public void writeToXML (StudentOrders studentOrders, StringWriter stringWriter) {
    try {
        JAXBContext jc = JAXBContext.newInstance(StudentOrders.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(studentOrders, stringWriter);
    } catch (JAXBException e) {
        e.printStackTrace();
    }


}


}
