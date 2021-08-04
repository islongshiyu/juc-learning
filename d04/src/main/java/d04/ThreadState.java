package d04;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j(topic = "d04.ThreadState")
public class ThreadState {
    public static void main(String[] args) throws IOException {

        /*
        t1线程初始化之后但一直未启动，状态为NEW
         */
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始执行...");
                }
            }
        };

        /*
        t2线程处于一直运行中，状态为RUNNABLE
         */
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                while (true) {
                    // RUNNABLE
                }
            }
        };
        t2.start();

        /*
        t3线程将正常运行完毕，状态为TERMINATED
         */
        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始执行...");
                }
            }
        };
        t3.start();

        /*
        t4线程调用sleep方法，状态为TIMED_WAITING，即有时限的等待
         */
        Thread t4 = new Thread("t4") {
            @Override
            public void run() {
                synchronized (ThreadState.class) {
                    try {
                        Thread.sleep(1000000); // TIMED_WAITING
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        /*
        t5线程中调用了t2的无参join方法，由于没有传入时间，t5的状态为WAITING，即无时限等待
        若调用带时间参数的join方法，状态为TIMED_WAITING，即有时限的等待
         */
        Thread t5 = new Thread("t5") {
            @Override
            public void run() {
                try {
                    t2.join(); // WAITING
                    //t2.join(100000); // TIMED_WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t5.start();

        /*
        t6线程和t4线程使用同一个锁对象，但t4线程先获得锁，并一直运行，此时t6将无法获得锁，其状态为 BLOCKED
         */
        Thread t6 = new Thread("t6") {
            @Override
            public void run() {
                synchronized (ThreadState.class) { // BLOCKED
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t6.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("t1 state {}", t1.getState());
        log.debug("t2 state {}", t2.getState());
        log.debug("t3 state {}", t3.getState());
        log.debug("t4 state {}", t4.getState());
        log.debug("t5 state {}", t5.getState());
        log.debug("t6 state {}", t6.getState());
    }
}
