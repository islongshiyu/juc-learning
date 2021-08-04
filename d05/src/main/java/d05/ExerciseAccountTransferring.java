package d05;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j(topic = "d05.ExerciseAccountTransferring")
public class ExerciseAccountTransferring {
    static Random R = new Random(); // Random为线程安全

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.transfer(a, randomAmount());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a.transfer(b, randomAmount());
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        if (log.isDebugEnabled()) {
            log.debug("总金额为：{}", a.getMoney() + b.getMoney());
        }
    }

    // 随机[1,100]
    public static int randomAmount() {
        return R.nextInt(100) + 1;
    }
}

class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void transfer(Account target, int amount) {
        if (this.money >= amount) {
            this.setMoney(this.getMoney() - amount);
            target.setMoney(target.getMoney() + amount);
        }
    }
}
