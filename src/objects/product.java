
package objects;

public class product {
    private int code;
    private String name;
    private int quantity;
    private float price;
    
    public product(int code, String name, int quantity, float price){
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public int getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public float getPrice(){
        return this.price;
    }
}
