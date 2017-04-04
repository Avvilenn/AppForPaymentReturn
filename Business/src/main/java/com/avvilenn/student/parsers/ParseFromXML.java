package com.avvilenn.student.parsers;




import com.avvilenn.student.domain.StudentOrders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class ParseFromXML {
    private static ParseFromXML ourInstance = new ParseFromXML();

    public static ParseFromXML getInstance() {
        return ourInstance;
    }

    private ParseFromXML() {
    }

    public StudentOrders readXML (InputStream inputStream) throws JAXBException {
        try {
            System.out.println("1");
            JAXBContext jc = JAXBContext.newInstance(StudentOrders.class);
            System.out.println("2");
            Unmarshaller u = jc.createUnmarshaller();
            System.out.println("3");
            StudentOrders studentOrders = (StudentOrders) u.unmarshal(inputStream);
            System.out.println(studentOrders);
            return studentOrders;
        } catch (JAXBException e) {
            e.printStackTrace();
            e = new JAXBException("parserFromXML");
            throw e;
        }
    }

}
