package d05;

public class MethodSynchronized {

    public synchronized void method1() {

    }

    public void method2() {
        synchronized (this) {

        }
    }

}