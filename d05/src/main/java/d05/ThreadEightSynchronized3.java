package d05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "d05.ThreadEightSynchronized3")
public class ThreadEightSynchronized3 {

    public static void main(String[] args) {
        ThreadEightSynchronizedObject3 object3 = new ThreadEightSynchronizedObject3();

        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object3.m1();
        }, "线程1");

        Thread t2 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object3.m2();
        }, "线程2");

        Thread t3 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object3.m3();
        }, "线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}

@Slf4j(topic = "d05.ThreadEightSynchronizedObject3")
class ThreadEightSynchronizedObject3 {
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

    public void m3() {
        if (log.isDebugEnabled()) {
            log.debug("3");
        }
    }
}
