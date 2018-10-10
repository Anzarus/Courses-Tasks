package com.hillel.elementary.teamleaders.threads.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Есть счетчик, подсчитывающий количество вызовов.
 * <p>
 * Почему счетчик показывает разные значения и не считает до конца?
 * Как это можно исправить?
 * <p>
 * Попробуйте закомментировать обращение к yield().
 * Измениться ли значение?
 */
public class CounterTask {
    private Integer counter = 0;
    private Object lock = new Object();

    class TestThread implements Runnable {
        String threadName;

        public TestThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    counter++;
                }
//                Thread.yield();
            }

        }
    }

    public void runJob() {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new TestThread("t" + i)));
        }
        System.out.println("Starting threads");
        for (int i = 0; i < 100; i++) {
            threads.get(i).start();
        }
        try {
            for (int i = 0; i < 100; i++) {
                threads.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter=" + counter);

    }

    public static void main(String[] args) {
        new CounterTask().runJob();
    }
}