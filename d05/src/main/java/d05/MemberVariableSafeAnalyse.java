package d05;

import java.util.ArrayList;
import java.util.List;

public class MemberVariableSafeAnalyse {
    private static final int THREADS = 2;

    private static final int LOOPS = 1000;

    public static void main(String[] args) {

        MObject mo = new MObject();

        for (int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                mo.m1(LOOPS);
            }, "t" + i).start();
        }

    }
}

class MObject {
    private List<String> list = new ArrayList<>();

    public void m1(int loops) {
        for (int i = 0; i < loops; i++) {
            m2();
            m3();
        }
    }

    private void m2() {
        list.add("1");// 添加字符串1
    }

    private void m3() {
        list.remove(0);// 移除首个元素
    }
}