package pers.zhang.part4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author zhang
 * @date 2020/1/15 - 20:35
 *
 * 使用JMX查看一个普通的Java程序包含哪些线程
 */
public class MultiThread {
    public static void main(String[] args) {
        //获取Jva线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronized信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历进程信息，仅打印线程ID和线程名称信息
        for(ThreadInfo threadInfo : threadInfos ){
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }


}
