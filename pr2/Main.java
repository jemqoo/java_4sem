package pr2;

public class Main {
    public static void main(String[] args){
        App Application = new App();

        System.out.println("\nВывод исходного списка");
        Application.printList();

        System.out.println("\nВыбор первых 5 элементов списка");
        Application.printFive();

        System.out.println("\nСортировка по дате рождения от старых к новым");
        Application.sortByDate();

        System.out.println("\nФильтрация по весу меньше, чем 60");
        Application.filterByWeightLess60();

        System.out.println("\nВывод имени и фамилии через пробел");
        Application.printName();
    }
}
