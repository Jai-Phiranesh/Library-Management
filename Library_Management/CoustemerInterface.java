package Library_Management;

public interface CoustemerInterface extends LibraryInterface{

    public  void borrowBook(Coustemer coustemer);

    public void returnBook(Coustemer coustemer);

    public void operation(Coustemer account,CoustemerActions coustemerActions);
    
} 
