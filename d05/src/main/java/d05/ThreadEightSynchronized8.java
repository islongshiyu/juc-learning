package d05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d05.ThreadEightSynchronized8")
public class ThreadEightSynchronized8 {

    public static void main(String[] args) {
        ThreadEightSynchronizedObject8 object81 = new ThreadEightSynchronizedObject8();
        ThreadEightSynchronizedObject8 object82 = new ThreadEightSynchronizedObject8();

        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object81.m1();
        }, "线程1");

        Thread t2 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object82.m2();
        }, "线程2");

        t1.start();
        t2.start();
    }
}

@Slf4j(topic = "d05.ThreadEightSynchronizedObject87")
class ThreadEightSynchronizedObject8 {
    public static synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (log.isDebugEnabled()) {
            log.debug("1");
        }
    }

    public static synchronized void m2() {
        if (log.isDebugEnabled()) {
            log.debug("2");
        }
    }
}
