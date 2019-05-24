
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
            JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
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
}
