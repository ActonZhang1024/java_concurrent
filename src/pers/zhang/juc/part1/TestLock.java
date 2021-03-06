package pers.zhang.juc.part1;

import sun.security.krb5.internal.Ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhang
 * @date 2020/1/17 - 19:54
 */
public class TestLock {
    public static void main(String[] args) {
        TrainTicket ticket = new TrainTicket();

        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}

class TrainTicket implements Runnable{

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){

            lock.lock(); //上锁

            try{
                if(tick > 0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }

                    System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
                }
            }finally{
                lock.unlock(); //释放锁
            }
        }
    }

}