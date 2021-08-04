package d05;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d05.ThreadSharedProblemSynchronizedObjectOriented")
public class ThreadSharedProblemSynchronizedObjectOriented {

    public static void main(String[] args) throws InterruptedException {

        Room room = new Room();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        });

        t1.setName("线程1");
        t1.start();

        t2.setName("线程2");
        t2.start();

        t1.join();

        t2.join();

        if (log.isDebugEnabled()) {
            log.debug("count的值为：{}", room.getCount());
        }
    }
}

class Room {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }
}