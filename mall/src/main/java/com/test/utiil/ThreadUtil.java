package com.test.utiil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {
    public static ExecutorService poll;

    static{
        poll = Executors.newFixedThreadPool(11);
    }
}
