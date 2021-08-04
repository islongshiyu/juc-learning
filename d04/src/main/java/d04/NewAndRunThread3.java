package d04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "d04.NewAndRunThread3")
public class NewAndRunThread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        1. 创建 FutureTask
         */
        FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                if (log.isDebugEnabled()) {
                    log.debug("开始运行...");
                }

                Thread.sleep(5000);//模拟耗时5秒执行任务

                return 100;
            }
        });

        /*
        2. 创建 Thread
         */
        Thread t = new Thread(ft, "爪哇测试线程3");

        /*
        3. 启动 Thread
         */
        t.start();

        if (log.isDebugEnabled()) {
            log.debug("继续执行");
        }

        /*
        4. 主线程获取结果（阻塞）
         */

        Integer result = ft.get();

        if (log.isDebugEnabled()) {
            log.debug("获取到任务执行完毕结果：{}", result);
        }
    }
}
