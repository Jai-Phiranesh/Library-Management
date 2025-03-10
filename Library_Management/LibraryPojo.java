package Library_Management;

import java.util.ArrayList;
import java.util.HashSet;

public class LibraryPojo {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static ArrayList<Books> bookList = new ArrayList<>();

    public static ArrayList<Books> getBookList() {
        return bookList;
    }

    private static HashSet<Integer> isbn = new HashSet<>();

    public static HashSet<Integer> getIsbn() {
        return isbn;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

}
