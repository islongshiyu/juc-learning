package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadPlanAsAWhole")
public class ThreadPlanAsAWhole {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("洗水壶");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (log.isDebugEnabled()) {
                log.debug("烧开水");
            }
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "老王");

        Thread t2 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("洗茶壶");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (log.isDebugEnabled()) {
                log.debug("洗茶杯");
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (log.isDebugEnabled()) {
                log.debug("拿茶叶");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (log.isDebugEnabled()) {
                log.debug("泡茶");
            }
        }, "小王");

        t1.start();
        t2.start();
    }
}
