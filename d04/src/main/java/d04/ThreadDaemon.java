package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadDaemon")
public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        if (log.isDebugEnabled()) {
            log.debug("开始运行...");
        }

        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始运行...");
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("运行结束...");
        }, "daemon");

        /*
        设置该线程为守护线程
         */
        t1.setDaemon(true);//
        t1.start();
        /*
        若在线程启动后再设置为守护线程会抛出IllegalThreadStateException
         */
        //t1.setDaemon(true);

        TimeUnit.SECONDS.sleep(1);

        if (log.isDebugEnabled()) {
            log.debug("结束运行...");
        }
    }
}
