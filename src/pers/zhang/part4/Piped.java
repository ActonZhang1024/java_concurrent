package pers.zhang.part4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author zhang
 * @date 2020/1/19 - 20:12
 *
 * 管道流
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输出和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);

        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();;
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1){
                out.write(receive);
            }
        }finally {
            out.close();
        }

    }


    static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try{
                while((receive = in.read()) != -1){
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
