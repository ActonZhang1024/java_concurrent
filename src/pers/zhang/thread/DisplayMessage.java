package pers.zhang.thread;

/**
 * @author zhang
 * @date 2020/1/15 - 0:35
 */
public class DisplayMessage implements Runnable {

    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}
