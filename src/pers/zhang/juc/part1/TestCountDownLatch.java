package pers.zhang.juc.part1;


import java.util.concurrent.CountDownLatch;

/**
 * @author zhang
 * @date 2020/1/16 - 19:58
 *
 * CountDownLatch：闭锁，在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行。
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        LatchDemo ld = new LatchDemo(latch);

        //开始时间
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            new Thread(ld).start();
        }

        //主线程等待其他10个线程执行完毕
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("10个并发线程共耗费时间为：" + (endTime - startTime));
    }
}


class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for(int i = 0; i < 50000; i++){
                    if(i % 2 == 0){
                        System.out.println(i);
                    }
                }
            }finally {
                latch.countDown();//计数器减一,必须执行
            }
        }
    }
}
