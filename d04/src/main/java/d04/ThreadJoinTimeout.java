package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d04.ThreadJoinTimeout")
public class ThreadJoinTimeout {
    static int r1 = 0;
    static int r2 = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });

        long start = System.currentTimeMillis();
        t1.start();


        if(log.isDebugEnabled()){
            log.debug("开始join...");
        }

        /*
        当等待时间小于线程执行时间时，将结束等待(未等够执行时间)
        当等待时间大于线程执行时间时 被等待的线程执行结束会导致调用 join 的线程提前结束等待(已等够执行时间)
         */
        //t1.join(1500);
        t1.join(3000);

        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} ,花费时间: {}", r1, r2, end - start);
    }
}
