package e02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "e02.TwoPhaseTermination")
public class TwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTerminationMonitor monitor = new TwoPhaseTerminationMonitor();

        monitor.start();//开始监控

        TimeUnit.SECONDS.sleep(7);

        monitor.stop();//停止监控
    }
}

@Slf4j(topic = "e02.TwoPhaseTerminationMonitor")
class TwoPhaseTerminationMonitor {
    Thread thread;//监控器线程

    /**
     * 开始监控
     */
    public void start() {
        thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    if (log.isDebugEnabled()) {
                        log.debug("料理后事释放资源...");
                    }
                    break;//释放完毕退出
                }

                try {
                    TimeUnit.SECONDS.sleep(2);//被打断情况1：睡眠时被打断，此时若被打断则会清空打断标记，处理异常时需要重新设置打断标记

                    if (log.isDebugEnabled()) {
                        log.debug("执行监控...");//被打断情况2：正常运行时被打断，此时不会清空打断标记，继续执行本次操作，下次循环结束运行
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();

                    Thread.currentThread().interrupt();//重新设置打断标记 如果不设置则会因为调用阻塞状态线程的interrupt会清空打断标记而无法终止程序
                }
            }
        });

        thread.start();
    }

    /**
     * 停止监控 设置打断标记即可
     */
    public void stop() {
        thread.interrupt();
    }
}
