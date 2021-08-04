package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadJoin")
public class ThreadJoin {
    static int r = 0;

    public static void main(String[] args) throws InterruptedException {
        if (log.isDebugEnabled()) {
            log.debug("{}线程开始运行..", Thread.currentThread().getName());
        }

        Thread t1 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();

            if (log.isDebugEnabled()) {
                log.debug("{}线程开始运行..", threadName);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (log.isDebugEnabled()) {
                log.debug("{}线程结束运行..", threadName);
            }

            r = 10;
        }, "t1");

        t1.start();
        t1.join();

        if (log.isDebugEnabled()) {
            log.debug("结果为：{}", r);
            log.debug("{}线程结束运行..", Thread.currentThread().getName());
        }
    }
}
