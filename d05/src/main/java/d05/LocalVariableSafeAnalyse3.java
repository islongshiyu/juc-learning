package d05;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableSafeAnalyse3 {
    private static final int THREADS = 2;

    private static final int LOOPS = 1000;

    public static void main(String[] args) {

        LObj3 lobj3 = new LObj3();

        for (int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                lobj3.m1(LOOPS);
            }, "t" + i).start();
        }

    }
}

class LObj3 {
    public void m1(int loops) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < loops; i++) {
            m2(list);
            m3(list);
        }
    }

    public void m2(List<String> list) {
        list.add("1");// 添加字符串1
    }

    public void m3(List<String> list) {
        list.remove(0);// 移除首个元素
    }
}