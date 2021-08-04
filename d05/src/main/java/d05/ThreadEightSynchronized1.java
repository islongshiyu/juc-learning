package d05;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d05.ThreadEightSynchronized1")
public class ThreadEightSynchronized1 {

    public static void main(String[] args) {
        ThreadEightSynchronizedObject1 object1 = new ThreadEightSynchronizedObject1();

        Thread t1 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object1.m1();
        }, "线程1");

        Thread t2 = new Thread(() -> {
            if (log.isDebugEnabled()) {
                log.debug("开始执行..");
            }

            object1.m2();
        }, "线程2");

        t1.start();
        t2.start();
    }
}

@Slf4j(topic = "d05.ThreadEightSynchronizedObject1")
class ThreadEightSynchronizedObject1 {
    public synchronized void m1() {
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
