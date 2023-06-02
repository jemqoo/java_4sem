package pr1;

public class Item implements Comparator<Item> {
    private int grade;

    Item(int grade){
        this.grade=grade;
    }

    @Override
    public int compare(Item o) {
        return Math.abs(this.grade)-Math.abs(o.grade);
    }
}
