package d04;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.RunningMultiThread")
public class RunningMultiThread {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                log.debug("开始运行...");
            }
        }, "线程A").start();

        new Thread(() -> {
            while (true) {
                log.debug("开始运行...");
            }
        }, "线程B").start();
    }
}
