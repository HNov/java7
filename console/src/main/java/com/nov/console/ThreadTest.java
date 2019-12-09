package com.nov.console;

public class ThreadTest {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("run:当前线程ID:" + Thread.currentThread());
            }
        };

        System.out.println("run:当前线程ID:" + Thread.currentThread());
        System.out.println("thread.run()");
        thread.run();
        System.out.println("thread.start()");
        thread.start();
        String s="";


        new Thread(new MyThread()).start();
        System.out.println("MyThread().run()");

    }


}

