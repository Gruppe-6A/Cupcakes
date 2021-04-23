package business.entities;

public class BasketItem {
    private Top top;
    private Bottom bottom;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public BasketItem(Bottom bottom, Top top, int quantity){
        this.top = top;
        this.bottom = bottom;
        this.quantity = quantity;
    }
    public double getPrice(){
        return (top.getPrice()+bottom.getPrice()) * quantity;
    }

    public Top getTop(){ return top;
    }
    public Bottom getBottom(){ return bottom;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }
}
