package pr1;

import pr1.Item;

public class Main {
    public static void main(String[] args) {
    Item ch1= new Item(25);
    Item ch2= new Item(-25);

    if(ch1.compare(ch2)>0){
        System.out.println("Первое число больше");
    }
    else if (ch1.compare(ch2)<0){
        System.out.println("Второе число больше");
    }
    else {
        System.out.println("Числа равны");
    }
    }
}