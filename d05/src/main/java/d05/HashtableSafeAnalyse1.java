package d05;

import java.util.Hashtable;

public class HashtableSafeAnalyse1 {
    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>();
        new Thread(() -> {
            table.put("key", "value1");
        }).start();
        new Thread(() -> {
            table.put("key", "value2");
        }).start();
    }
}
