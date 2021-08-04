package d04;

import d04.utils.ResourceReadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.ThreadStartAndRun")
public class ThreadStartAndRun {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始运行...");
                }
                ResourceReadUtil.read(Constants.ULTRA_MAN_MP4_RES_PATH);
            }
        };

        /*
        错误的使用方式！直接调用run方法将被主线程作为t1对象的普通方法调，而不是通过新创建的线程调用
         */

        //t1.run();

        /*
        正确的使用方式
         */
        t1.start();

        if (log.isDebugEnabled()) {
            log.debug("做其他事情...");
        }
    }
}
