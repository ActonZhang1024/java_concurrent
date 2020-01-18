package pers.zhang.juc.part1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhang
 * @date 2020/1/16 - 17:52
 *
 * 并发编程中的原子性问题
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for(int i = 0; i < 20; i++){
            new Thread(ad,"thread" + i).start();
        }
    }
}

class AtomicDemo implements Runnable{

    private volatile AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber.getAndIncrement();//获取并自增
    }
}
