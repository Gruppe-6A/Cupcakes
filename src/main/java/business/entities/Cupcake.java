package business.entities;

public class Cupcake
{

    public Cupcake(String bottom, String topping, int amount)
    {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String bottom;
    private String topping; // Should be hashed and secured
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
