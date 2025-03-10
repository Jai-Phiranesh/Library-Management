package Library_Management;

import java.util.ArrayList;

public class Coustemer  extends Account{

    private ArrayList<Books> borrowBooks;

    Coustemer(String user,String pass,ArrayList<Books> borrowBooks){
        super(user, pass);
        this.borrowBooks=borrowBooks;
    }
    
    public ArrayList<Books> getBorrowBooks() {
        return borrowBooks;
    }
}
