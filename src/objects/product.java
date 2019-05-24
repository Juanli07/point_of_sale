
package objects;

public class product {
    private int id;
    private String name;
    private String code;
    private int quantity;
    private float price;
    
    public product(int id, String name, String code, int quantity, float price){
        this.id = id;
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public float getPrice(){
        return this.price;
    }
}
