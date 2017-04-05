package com.avvilenn.student.checkers;


import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.domain.StudentOrders;
import com.avvilenn.student.emailSender.SendEmail;
import com.avvilenn.student.exceptions.BusinessException;
import com.avvilenn.student.managers.CheckerManager;

public class BasicChecker extends Thread {
    private CheckerManager manager = CheckerManager.getInstance();
    private SendEmail sendEmail = new SendEmail();

    @Override
    public void run() {
        System.out.println("basic checker run");
        GetStudentOrders.setOrders();
        GRNchecker grn = new GRNchecker();
        grn.start();
        ZAGSchecker zags = new ZAGSchecker();
        zags.start();
        StudentChecker studentChecker = new StudentChecker();
        studentChecker.start();

        StudentOrders orders = GetStudentOrders.getOrders();
        for (StudentOrder order: orders.getStudentOrders()) {
            try {
                boolean grnAn = manager.getGRNanswer(order);
                boolean zagsAn = manager.getZAGSanswer(order);
                boolean studentAn = manager.getStudentAnswer(order);
                if (grnAn==true&&zagsAn==true&&studentAn==true){
                    System.out.println("отправить письмо запрос выплаты одобрен");
                    sendEmail.sendEmail();
                } else {
                    System.out.println("отправить письмо запрос выплаты отклонен");
                    sendEmail.sendEmail();
                }
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }



    }
}
