package com.hillel.elementary.teamleaders.threads.tasks;

/**
 * Как сделать так, чтобы потоки вызывались по очереди?
 * <p>
 * Часто необходимо упорядочить потоки, т.к. результат одного потока
 * понадобится другому, и нужно дождаться, когда первый поток сделает свою работу.
 * <p>
 * Задача: добавьте еще один поток, который будет выводить в лог сообщения о
 * значениях счетчика, кратных 10, например 10, 20, 30...
 * При этом такие сообщения должны выводиться после того, как все потоки преодолели
 * кратность 10, но до того, как какой-либо поток двинулся дальше.
 */

public class WaitTask {
    private final Object monitor = new Object();
    private int t1Counter = 0, t2Counter = 0;
    private volatile boolean inProcess = true;
    private volatile boolean once = true;
    private volatile boolean sendFlagFromOne = false;
    private volatile boolean sendFlagToOne = false;
    private volatile boolean sendFlagFromTwo = false;
    private volatile boolean sendFlagToTwo = false;

    class TestThread implements Runnable {
        String threadName;
        int n;

        public TestThread(String threadName, int n) {
            this.threadName = threadName;
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(threadName + ":" + i);
                synchronized (monitor) {
                    if (n == 1) t1Counter = i;
                    if (n == 2) t2Counter = i;
                    monitor.notifyAll();
                    Thread.yield();
                    try {
                        if (n == 1) {
                            while (i > t2Counter) {
                                System.out.println("t1 is ahead with i=" + i + ", wait for t2Counter=" + t2Counter);
                                monitor.wait();
                            }
                            while (t1Counter % 10 == 0 && !sendFlagToOne) {
                                once = true;
                                sendFlagFromOne = false;
                                monitor.wait();
                            }
                            sendFlagFromOne = true;
                            sendFlagToOne = false;
                        }
                        if (n == 2) {
                            while (i > t1Counter) {
                                System.out.println("t2 is ahead with i=" + i + ", wait for t1Counter=" + t1Counter);
                                monitor.wait();
                            }
                            while (t2Counter % 10 == 0 && !sendFlagToTwo) {
                                once = true;
                                sendFlagFromTwo = false;
                                monitor.wait();
                            }
                            sendFlagFromTwo = true;
                            sendFlagToTwo = false;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.yield();
            }
            System.out.println("Exiting " + threadName);
            inProcess = false;
        }
    }

    class ThirdThread implements Runnable {
        String threadName;

        public ThirdThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while (inProcess) {
                synchronized (monitor) {
                    if (!sendFlagFromOne) {
                        if (!sendFlagFromTwo) {
                            if (once) {
                                System.out.println("\t\t\t" + threadName + "gets (" + t1Counter + "," + t2Counter + ")");
                                sendFlagToOne = true;
                                sendFlagToTwo = true;
                                monitor.notifyAll();
                                once = false;
                            }
                        }
                    }
                }
            }
            System.out.println("Exiting " + threadName);
        }
    }


    public void runJob() {
        Thread t1 = new Thread(new TestThread("t1", 1));
        Thread t2 = new Thread(new TestThread("t2", 2));

        Thread t3 = new Thread(new ThirdThread("t3"));

        System.out.println("Starting threads");
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Waiting for threads");
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WaitTask().runJob();
    }
}
