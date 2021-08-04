package d05;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d05.ThreadSharedProblemSynchronized")
public class ThreadSharedProblemSynchronized {

    private final static Object room = new Object();
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    count--;
                }
            }
        });

        t1.setName("线程1");
        t1.start();

        t2.setName("线程2");
        t2.start();

        t1.join();

        t2.join();

        if (log.isDebugEnabled()) {
            log.debug("count的值为：{}", count);
        }
    }
}
