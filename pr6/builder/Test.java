package pr6.builder;

public class Test {
    public static void main(String[] args) {
        DirectorCar car = new DirectorCar();
        CarBuilder builder = new CarBuilder();
        car.createHisCar(builder);
        System.out.println(builder.getResult());
    }
}

// Паттерн «Строитель» – разделяет создание объекта на отдельные шаги, а также позволяет использовать один и тот же код создания для
//получения различных представлений