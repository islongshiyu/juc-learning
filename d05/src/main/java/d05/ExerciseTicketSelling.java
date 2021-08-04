package d05;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * for /L %n in (1,1,10) do java -cp ".;%USERPROFILE%\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;%USERPROFILE%\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;%USERPROFILE%\.m2\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar" d05.ExerciseTicketSelling
 */
@Slf4j(topic = "d05.ExerciseTicketSelling")
public class ExerciseTicketSelling {
    private final static Random R = new Random();// Random是线程安全的

    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow(2000);

        List<Thread> threads = new ArrayList<>();

        List<Integer> sells = new Vector<>();

        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(() -> {
                // 分析这里的竞态条件
                int sold = tw.sell(randomAmount());
                sells.add(sold);
            });

            threads.add(t);

            t.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        if (log.isDebugEnabled()) {
            log.debug("卖出的票总数为：{}", sells.stream().mapToInt(tmp -> tmp).sum());
            log.debug("剩余的票总数为：{}", tw.getCount());
        }
    }

    public static int randomAmount() {
        return R.nextInt(5) + 1;// 随机1-5
    }

}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int sell(int amount) {
        if (this.count >= amount) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);// 模拟买票耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.count -= amount;// 剩余数量=当前数量-卖出数量

            return amount;
        }

        return 0;
    }
}
