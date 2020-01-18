package pers.zhang.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zhang
 * @date 2020/1/17 - 15:15
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3};
        AtomicIntegerArray aia = new AtomicIntegerArray(arr);
        aia.getAndSet(0, 3);
        System.out.println(aia.get(0));
        System.out.println(arr[0]);
    }
}
