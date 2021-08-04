package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "d04.ThreadParkInterrupt1")
public class ThreadParkInterrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("park...");
            }

            LockSupport.park();

            if (log.isDebugEnabled()) {
                log.debug("unpark by interrupt");
                log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
            }
        });

        t.start();

        TimeUnit.SECONDS.sleep(1);

        t.interrupt();
    }
}
