package pers.zhang.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhang
 * @date 2020/1/17 - 15:04
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);

        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }

}
