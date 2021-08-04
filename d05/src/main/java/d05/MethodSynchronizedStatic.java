package d05;

public class MethodSynchronizedStatic {

    public synchronized static void method1() {

    }

    public static void method2() {
        synchronized (MethodSynchronizedStatic.class) {

        }
    }

}