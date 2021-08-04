package d04;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.NewAndRunThread2")
public class NewAndRunThread2 {
    public static void main(String[] args) {
        /*
        1. 创建 Runnable 对象
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始运行...");
                }
            }
        };

        /*
        2. 创建 Thread
         */
        Thread t = new Thread(r, "爪哇测试线程2");

        /*
        3. 启动 Thread
         */
        t.start();
    }
}
