package Library_Management;

public interface LibraryInterface {

    public Account login();

    public void searchBook(String tile);

    public void searchBook(int isbn);

}
