package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadSleepWithTimeUnit")
public class ThreadSleepWithTimeUnit {
    public static void main(String[] args) throws InterruptedException {
        if (log.isDebugEnabled()) {
            log.debug("开始睡眠...");
        }
        /*
        可读性差的写法
         */
        Thread.sleep(1000);
        /*
        良好的可读性 JDK1.5后新增
         */
        TimeUnit.SECONDS.sleep(1);
        if (log.isDebugEnabled()) {
            log.debug("结束睡眠...");
        }
    }
}
