
package objects;

public class user {
    private int id;
    private String username;
    private String pass;
    private String full_name;
    
    public user(int id, String username, String pass, String full_name){
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.full_name = full_name;
    }
    public int getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPass(){
        return this.pass;
    }
    public String getFull_name(){
        return this.full_name;
    }
}
