package Library_Management;

public interface AdminInterface extends LibraryInterface {
    public  void addBook();

    public  void removeBook();

    public void operation(AdminActions adminActions);
    
} 