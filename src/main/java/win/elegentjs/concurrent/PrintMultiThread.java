package win.elegentjs.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 验证jvm启动后会启动多个线程
 *
 * Signal Dispatcher ： 信号分发线程
 * Finalizer： 垃圾收集线程
 * Reference Handler: 清理引用线程
 * main：main线程
 *
 */
public class PrintMultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo item : threadInfos) {
            System.out.println("threadId : ["  + item.getThreadId() +  "], threadName: " + item.getThreadName());
        }
    }
}
