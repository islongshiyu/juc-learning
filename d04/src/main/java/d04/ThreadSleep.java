package d04;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.ThreadSleep")
public class ThreadSleep {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();

        if (log.isDebugEnabled()) {
            log.debug("线程t1状态: {}", t1.getState());
        }

        try {
            /*
            主线程短暂睡眠后再去获取t1线程状态 避免主线程执行过快 t1线程还未进入睡眠状态 获取到的t1线程状态不正确
             */
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (log.isDebugEnabled()) {
            log.debug("线程t1状态: {}", t1.getState());
        }
    }
}
