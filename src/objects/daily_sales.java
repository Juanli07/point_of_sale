
package objects;

public class daily_sales {
    private String date;
    private float quantity;
    
    public daily_sales(String date, float quantity){
        this.date = date;
        this.quantity = quantity;
    }
    
    public String getDate(){
        return this.date;
    }
    public float getQuantity(){
        return this.quantity;
    }
}
