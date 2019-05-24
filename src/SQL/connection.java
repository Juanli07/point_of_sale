
package SQL;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import objects.*;
import java.util.ArrayList;
import java.util.List;

public class connection {
    public static final String URL = "jdbc:mysql://localhost:3306/point";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1431";
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
             System.out.println("CONEXION EXITOSA");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("ERROR" + e.getMessage());
        }
        return con;
    }
    
    public List<user> getUsers(){
        List<user> users = new ArrayList();
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
            ResultSet res= ps.executeQuery();
            while(res.next()){
                users.add(new user(res.getInt("id"), res.getString("username"), res.getString("pass"), res.getString("full_name")));
            }
        }catch(SQLException e){
            System.out.println("No existen datos");
        }
        return users;
    }
    
    
    
     public List<product> getProducts(){
        List<product> products = new ArrayList();
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM product");
            ResultSet res= ps.executeQuery();
            while(res.next()){
                products.add(new product(res.getInt("code"), res.getString("name"), res.getInt("quantity"), res.getFloat("price")));
            }
        }catch(SQLException e){
            System.out.println("No existen datos");
        }
        return products;
    }
     
     public List<product> getProducts(int code){
        List<product> products = new ArrayList();
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE code LIKE '"+code+"%'");
            ResultSet res= ps.executeQuery();
            while(res.next()){
                products.add(new product(res.getInt("code"), res.getString("name"), res.getInt("quantity"), res.getFloat("price")));
            }
        }catch(SQLException e){
            System.out.println("No existen datos");
        }
        return products;
    }
     
      public List<product> getProducts(String name){
        List<product> products = new ArrayList();
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE name LIKE '"+name+"%'");
            ResultSet res= ps.executeQuery();
            while(res.next()){
                products.add(new product(res.getInt("code"), res.getString("name"), res.getInt("quantity"), res.getFloat("price")));
            }
        }catch(SQLException e){
            System.out.println("No existen datos");
        }
        return products;
    }
     
    public List<daily_sales> getDaily_sales(){
        List<daily_sales> daily = new ArrayList();
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM product");
            ResultSet res= ps.executeQuery();
            while(res.next()){
                daily.add(new daily_sales(res.getString("date"), res.getFloat("quantity")));
            }
        }catch(SQLException e){
            System.out.println("No existen datos");
        }
        return daily;
    }
    
    public void saveUser(user users) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (username, pass, full_name) VALUES(?, ? ,?)");
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPass());
            ps.setString(3, users.getFull_name());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No sé pudo insertar el dato");
        }
    }
    public void saveProduct(product products) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO product (code, name, quantity, price) VALUES(?, ?, ? ,?)");
            ps.setInt(1, products.getCode());
            ps.setString(2, products.getName());
            ps.setInt(3, products.getQuantity());
            ps.setFloat(4, products.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No sé pudo insertar el dato");
        }
    }
    
    public void saveDaily(daily_sales daily) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO daily_sales (quantity) VALUES(?)");
            ps.setFloat(1, daily.getQuantity());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No sé pudo insertar el dato");
        }
    }
    
    public void updateUser(user users){
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE user SET username = ?, pass = ?, full_name = ? WHERE username = ?");
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPass());
            ps.setString(3, users.getFull_name());
            ps.setString(4, users.getUsername());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No sé pudo insertar el dato");
        }
    }
    
    public void updateProduct(product products){
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE product SET quantity = ?, price = ? WHERE code = ?");
            ps.setInt(1, products.getQuantity());
            ps.setFloat(2, products.getPrice());
            ps.setInt(3, products.getCode());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No sé pudo insertar el dato");
        }
    }
    
     public void updateDaily(daily_sales daily) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE daily_sales SET quantity = ? WHERE date = ?");
            ps.setFloat(1, daily.getQuantity());
            ps.setString(2, daily.getDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("No sé pudo insertar el dato");
        }
    }
}
