package pr2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class App {
    List<Human> humans = new ArrayList<>(10);
    public App() {
        humans.add(new Human(19, "Julia", "Soldatenkova", LocalDate.of(2003, 5, 15), 53));
        humans.add(new Human(19, "Erica", "Tsvetkova", LocalDate.of(2004, 1, 7), 60));
        humans.add(new Human(19, "Marat", "Gadziev", LocalDate.of(2003, 8, 3), 70));
        humans.add(new Human(22, "Aboba", "Boba", LocalDate.of(2000, 9, 15), 100));
        humans.add(new Human(23, "Kolya", "Popov", LocalDate.of(1999, 3, 17), 89));
        humans.add(new Human(52, "Taras", "Tarasov", LocalDate.of(1970, 6, 13), 110));
        humans.add(new Human(19, "Sonya", "Chistyakova", LocalDate.of(2003, 3, 20), 58));
        humans.add(new Human(19, "Vera", "Baburova", LocalDate.of(2004, 1, 17), 62));
        humans.add(new Human(19, "Frosya", "Pupkina", LocalDate.of(2003, 7, 23), 78));
        humans.add(new Human(22, "Nikita", "Ivanov", LocalDate.of(2000, 11, 11), 59));
}

    public void printList(){
        Stream<Human> stream = humans.stream();
        stream.forEach(System.out::println);
    }
    public void printFive(){
        Stream<Human> stream = humans.stream().limit(5);
        stream.forEach(System.out::println);
    }

    public void sortByDate(){
        Stream<Human> stream = humans.stream();
        stream
                .sorted(Comparator.comparing(h -> h.birthDate))
                .forEach(System.out::println);
    }

    public void filterByWeightLess60(){
        Stream<Human> stream = humans.stream();
        stream.filter(a -> a.weight < 60).forEach(System.out::println);
    }

    public void printName(){
        Stream<Human> stream = humans.stream();
        stream.map(i->i.firstName + " " + i.lastName).forEach(System.out::println);
    }
}