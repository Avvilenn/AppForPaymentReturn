package com.avvilenn.student.timeTasks;


import com.avvilenn.student.checkers.BasicChecker;

public class HourlyJob  implements Runnable {
    public void run() {
        BasicChecker checker = new BasicChecker();
        checker.start();
    }
}

