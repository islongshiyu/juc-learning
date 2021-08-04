package d05;

import java.util.Hashtable;

public class HashtableSafeAnalyse2 {
    public static void main(String[] args) throws InterruptedException {
        Hashtable<String, String> table = new Hashtable<>();
        new Thread(() -> {
            if (table.get("key") == null) {
                table.put("key", "value");
            }
        }).start();
        new Thread(() -> {
            if (table.get("key") == null) {
                table.put("key", "value");
            }
        }).start();
    }
}
