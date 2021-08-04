package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadJoinMulti")
public class ThreadJoinMulti {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 20;
        });

        t1.start();
        t2.start();

        long start = System.currentTimeMillis();



        if (log.isDebugEnabled()) {
            log.debug("开始join线程t2");
        }
        t2.join();
        if (log.isDebugEnabled()) {
            log.debug("结束join线程t2");
        }

        if (log.isDebugEnabled()) {
            log.debug("开始join线程t1");
        }
        t1.join();
        if (log.isDebugEnabled()) {
            log.debug("结束join线程t1");
        }

        long end = System.currentTimeMillis();

        if (log.isDebugEnabled()) {
            log.debug("r1:{}, r2:{}, 花费时间:{}", r1, r2, (end - start));
        }
    }
}
