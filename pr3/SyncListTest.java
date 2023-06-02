package pr3;

import java.util.*;

import static java.lang.Thread.sleep;

public class SyncListTest {
    public static void main(String[] args) {
        List <Integer> list = new SynchronizedArrayList();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                list.add(i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 21; i < 40; i++) {
                list.add(i);
            }
        });

        one.start();
        two.start();

        System.out.println("SynchronizedList:");
        list.forEach((a) -> System.out.print(a + " "));
    }
}
