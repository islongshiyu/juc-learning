package d04;

import lombok.extern.slf4j.Slf4j;

/**
 * 只要有一个前台（非守护）线程还在运行，Java进程就不会结束
 */
@Slf4j(topic = "d04.ThreadDaemonNon")
public class ThreadDaemonNon {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            if (log.isDebugEnabled()) {
                log.debug("非守护子线程结束运行..");
            }
        }, "t1");
        t1.start();

        Thread.sleep(1000);

        if (log.isDebugEnabled()) {
            log.debug("主线程结束运行..");
        }
    }
}
