package d04;

public class DebugMultiThreadStackFrames {
    public static void main(String[] args) {
        Thread t = new Thread(() -> method1(20));
        t.setName("t");
        t.start();
        method1(10);
    }

    private static void method1(int x) {
        int y = x + 1;
        System.out.println(y);
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        return new Object();
    }
}
