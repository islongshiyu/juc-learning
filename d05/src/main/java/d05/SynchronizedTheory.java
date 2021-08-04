package d05;

public class SynchronizedTheory {
    private static final Object LOCK = new Object();

    private static int COUNTER = 0;

    public static void main(String[] args) {
        synchronized (LOCK) {
            COUNTER++;
        }
    }
}
