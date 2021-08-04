package d05;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d05.CriticalSection")
public class CriticalSection {
    static int count = 0;

    static void increment()
    //临界区代码块
    {
        count++;
    }

    static void decrement()
    //临界区代码块
    {
        count--;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        }, "线程1");

        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement();
            }
        }, "线程2");

        t2.start();

        if(log.isDebugEnabled()){
            log.debug("count的值为：{}",count);
        }
    }
}
