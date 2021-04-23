package business.entities;

public class Cupcake
{

    public Cupcake(int bottom, int topping, int quantity)
    {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
       // this.cupcakes_id = cupcakes_id;
        //  this.orders_id = orders_id;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private int bottom;
    private int topping; // Should be hashed and secured
    private int quantity;
    private int cupcakes_id;
    private int orders_id;

    public int getOrders_id(){
        return cupcakes_id;
    }

    public int getCupcakes_id() {
        return cupcakes_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
