package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadNonBlockedInterrupt")
public class ThreadNonBlockedInterrupt {
    public static void main(String[] args) throws InterruptedException {
        if (log.isDebugEnabled()) {
            log.debug("开始执行");
        }

        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行");
            }
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    if (log.isDebugEnabled()) {
                        log.debug("检测到打断标记退出循环");
                    }
                    break;
                }
            }
            if (log.isDebugEnabled()) {
                log.debug("结束执行");
            }
        }, "t1");
        t1.start();

        TimeUnit.SECONDS.sleep(1);

        if (log.isDebugEnabled()) {
            log.debug("执行打断");
        }

        /*
        interrupt方法并不会打断正常运行的线程，只会设置线程的打断标记为true
        被打断线程根据打断标记来自行决定是否停止运行，这是一种优雅的方式
         */
        t1.interrupt();
        if (log.isDebugEnabled()) {
            log.debug("结束执行");
        }
    }
}
