package pers.zhang.part4;

import java.util.concurrent.TimeUnit;

/**
 * @author zhang
 * @date 2020/1/15 - 22:20
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
