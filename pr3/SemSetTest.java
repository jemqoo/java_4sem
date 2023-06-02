package pr3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemSetTest {
    public static void main(String[] args) {
        Set <Integer> set = new HashSet<>();
        Set <Integer> mySet = new SemaphoreSet<>();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                set.add(i);
                mySet.add(i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 21; i < 41; i++) {
                set.add(i);
                mySet.add(i);
            }
        });

        one.start();
        two.start();

//        System.out.println(mySet);
        mySet.forEach(System.out::println);
        System.out.println("\n\n\n" + set);
    }
}
