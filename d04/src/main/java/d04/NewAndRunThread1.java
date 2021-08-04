package d04;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.NewAndRunThread1")
public class NewAndRunThread1 {
    public static void main(String[] args) {
        /*
        1. 创建 Thread
         */
        Thread t = new Thread() {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始运行...");
                }
            }
        };

        /*
        注：养成为线程设置名称的良好习惯 源码中默认线程名称"Thread-" + nextThreadNum() 辨识度极低
         */
        t.setName("爪哇测试线程1");

        /*
        2. 启动 Thread
         */
        t.start();
    }
}
