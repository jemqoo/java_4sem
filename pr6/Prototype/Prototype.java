package pr6.Prototype;

public class Prototype {
    public static void main (String[] args)
    {
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("blue").addColor();
    }
}

// Паттерн «Прототип» – позволяет копировать объекты без обращения к приватному состоянию извне
