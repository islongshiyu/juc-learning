package d05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d05.ThreadEightSynchronized2")
public class ThreadEightSynchronized2 {

    public static void main(String[] args) {
        ThreadEightSynchronizedObject2 object2 = new ThreadEightSynchronizedObject2();

        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object2.m1();
        }, "线程1");

        Thread t2 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object2.m2();
        }, "线程2");

        t1.start();
        t2.start();
    }
}

@Slf4j(topic = "d05.ThreadEightSynchronizedObject2")
class ThreadEightSynchronizedObject2 {
    public synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (log.isDebugEnabled()) {
            log.debug("1");
        }
    }

    public synchronized void m2() {
        if (log.isDebugEnabled()) {
            log.debug("2");
        }
    }
}
