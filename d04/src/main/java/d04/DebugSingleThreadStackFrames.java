package d04;

public class DebugSingleThreadStackFrames {
    public static void main(String[] args) {
        method1(10);
    }

    private static void method1(int x) {
        int y = x + 1;
        System.out.println(y);
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object o = new Object();
        System.out.println(o);
        return o;
    }
}
