package e01;

/**
 * 在单核CPU下进行测试，多核CPU下无法达到利用率100%
 */
public class CPULimitWithSleep {
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}