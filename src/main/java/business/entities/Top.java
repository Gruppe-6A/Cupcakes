package business.entities;

public class Top {
    private int toppings_id;
    private String name;
    private double price;

    public Top(int toppings_id, String name, double price) {
        this.toppings_id = toppings_id;
        this.name = name;
        this.price = price;
    }
}
