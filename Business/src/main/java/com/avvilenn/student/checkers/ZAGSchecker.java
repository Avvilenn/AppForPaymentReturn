package com.avvilenn.student.checkers;

import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.CheckerManager;
import com.avvilenn.student.parsers.ParseFromXML;
import com.avvilenn.student.parsers.ParseToXML;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;

public class ZAGSchecker extends Thread {
    private ParseFromXML fromXML = ParseFromXML.getInstance();;
    private ParseToXML toXML = ParseToXML.getInstance();
    private CheckerManager manager = CheckerManager.getInstance();


    @Override
    public void run() {
        StudentOrders orders = GetStudentOrders.getOrders();
        try {
            int port = 40247;
            System.out.println("Try to open connection:" + port);
            Socket socket = new Socket("127.0.0.1", port);
            System.out.println("Connection is created");
            StringWriter sw = new StringWriter();
            toXML.writeToXML(orders, sw);
            StringBuilder str = new StringBuilder(sw.getBuffer());
            String s = str.toString();
            System.out.println(s);
            OutputStream os = socket.getOutputStream();
            os.write(s.getBytes());
            System.out.println("отправлено на сервер");

            StudentOrders answer = fromXML.readXML(socket.getInputStream());
            manager.updateZAGS(answer);
            System.out.println("zags ответ получен");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}
