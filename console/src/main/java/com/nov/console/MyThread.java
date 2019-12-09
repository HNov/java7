package com.nov.console;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("MyThread:" + Thread.currentThread());
    }
}
