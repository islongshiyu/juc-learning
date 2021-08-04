package d04;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d04.ThreadStartAndRunState")
public class ThreadStartAndRunState {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                if (log.isDebugEnabled()) {
                    log.debug("开始运行...");
                }
            }
        };

        System.out.println(t1.getState());//NEW
        t1.start();
        System.out.println(t1.getState());//RUNNABLE
        //t1.start();//重复启动线程将导致 IllegalThreadStateException
    }
}
