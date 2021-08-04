package d04;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.TheadSleepInterrupt")
public class TheadSleepInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始执行...");
                }
                try {
                    if (log.isDebugEnabled()) {
                        log.debug("进入睡眠...");
                    }
                    Thread.sleep(2000);
                    if (log.isDebugEnabled()) {
                        log.debug("结束睡眠...");
                    }
                } catch (InterruptedException e) {
                    if(log.isDebugEnabled()){
                        log.debug("打断睡眠...");
                    }
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        Thread.sleep(1000);//主线程睡眠1秒后打断t1线程

        if (log.isDebugEnabled()) {
            log.debug("执行打断...");
        }

        t1.interrupt();
    }
}
