package com.test.service;

import java.util.Timer;
import java.util.TimerTask;

public class TimeService {


    public static void main(String[] args) {

        Timer t = new Timer();
        t.schedule(new test(),2000,2000);
    }

}

class test extends TimerTask{

    @Override
    public void run() {
        System.out.println("have a try...");
    }
}
