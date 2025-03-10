package Library_Management;

public class Account {

    Account(String username,String pass){
        this.userName=username;
        this.password=pass;
    }
   
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
