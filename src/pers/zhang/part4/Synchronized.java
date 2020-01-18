package pers.zhang.part4;

/**
 * @author zhang
 * @date 2020/1/15 - 23:55
 */
public class Synchronized {
    public static void main(String[] args) {
        //对Synchronized Class 对象进行加锁
        synchronized (Synchronized.class){

        }
        //静态同步方法，对Synchronized Class对象进行加速
        m();
    }

    public static synchronized void m(){};
}
