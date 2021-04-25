package business.entities;

public class CupcakeEntry
{

    public CupcakeEntry(String email,int orders_id,String bottom, String topping)
    {
        this.email = email;
        this.bottom = bottom;
        this.topping = topping;
        this.orders_id = orders_id;
       // this.cupcakes_id = cupcakes_id;
        //this.orders_id = orders_id;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String bottom;
    private String topping; // Should be hashed and secured
    private int quantity;
    private int cupcakes_id;
    private int orders_id;

    public int getOrders_id(){
        return cupcakes_id;
    }

    public int getCupcakes_id() {
        return cupcakes_id;
    }

    public String getEmail() {
        return email;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
