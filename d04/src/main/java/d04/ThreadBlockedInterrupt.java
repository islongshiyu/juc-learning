package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadBlockedInterrupt")
public class ThreadBlockedInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始睡眠");
            }
            try {
                TimeUnit.SECONDS.sleep(5); // sleep, wait, join
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        try {
            /*
            主线程睡眠1秒后再执行打断 避免执行过快 t1 线程未进入睡眠
             */
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (log.isDebugEnabled()) {
            log.debug("执行打断");
        }

        t1.interrupt();

        if (log.isDebugEnabled()) {
            log.debug("{}线程打断标记：{}", t1.getName(), t1.isInterrupted());
        }
    }
}
