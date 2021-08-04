package d04;

public class ThreadYield {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (; ; ) {
                System.out.println("---->线程1 " + count++);
            }
        };

        Runnable task2 = () -> {
            int count = 0;
            for (; ; ) {
                Thread.yield();
                System.out.println("              ---->线程2 " + count++);
            }
        };

        Thread t1 = new Thread(task1, "线程1");
        Thread t2 = new Thread(task2, "线程2");

        t1.start();
        t2.start();
    }
}
