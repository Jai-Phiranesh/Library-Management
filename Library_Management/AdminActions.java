package Library_Management;

import java.util.Scanner;

public class AdminActions implements AdminInterface {
    Scanner scanner = new Scanner(System.in);

    public void operation(AdminActions adminActions){
        while(true){
        System.out.println();
            System.out.println("1.Add Book \n2.Remove Book \n3.Search a Book \n4.Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    adminActions.addBook();
                    break;

                case 2:
                    adminActions.removeBook();
                    break;

                case 3:
                    if (LibraryPojo.getBookList().isEmpty()) {
                        System.out.println("No Books");
                        break;
                    }

                    System.out.println("1.Search by Title\n2.Search by Isbn");
                    int choiceSearch = Integer.parseInt(scanner.nextLine());

                    if (choiceSearch == 1) {
                        System.out.println("Enter The Title:");
                        String title = scanner.nextLine();
                        adminActions.searchBook(title);
                    } else if (choiceSearch == 2) {
                        System.out.println("Enter The ISBN Number:");
                        int number = Integer.parseInt(scanner.nextLine());
                        adminActions.searchBook(number);

                    } else {
                        System.out.println("Invalid Input Try Again");
                    }
                    break;

                case 4:
                    System.out.println("Existing......");
                    return;

                default:
                    System.out.println("Invalid Input Try Again..");

            }}
    }

    @Override
    public Account login(){
        System.out.println("Enter the User Name:");
                    String username = scanner.nextLine();

                    System.out.println("Enter the Password");
                    String password = scanner.nextLine();

                    for(Account accout : LibraryPojo.getAccounts()){
                        if(accout instanceof Admin){
                            if(accout.getUserName().equals(username) && accout.getPassword().equals(password)){
                                return accout;
                            }
                        }
                        
                    }
                    return null;
    }

    @Override
    public  void addBook() {

        System.out.println("Enter the Book Title To Add:");
        String name = scanner.nextLine();

        System.out.println("Enter the Author To Add");
        String author = scanner.nextLine();
        while (true) {
            System.out.println("Enter the isbn number");

            int isbn = Integer.parseInt(scanner.nextLine());

            if (!(LibraryPojo.getIsbn().contains(isbn))) {
                LibraryPojo.getBookList().add(new Books(name, author, true, isbn));
                System.out.println("Added SuccessFully");
                LibraryPojo.getIsbn().add(isbn);
                return;
            } else {
                System.out.println("Isbn already Exists Try Again...");
                continue;
            }

        }

    }

    @Override
    public  void removeBook() {
        boolean flag = false;
        if (LibraryPojo.getBookList().isEmpty()) {
            System.out.println("No Books");
            return;
        }

        System.out.println("Enter the Book ISBN To Remove:");
        int isbn = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < LibraryPojo.getBookList().size(); i++) {
            if (LibraryPojo.getBookList().get(i).getIsbn() == isbn) {
                flag = true;
                LibraryPojo.getBookList().remove(LibraryPojo.getBookList().get(i));
                System.out.println("Removed SuccessFully.......");
            }
        }
        if (!flag) {
            System.out.println("No books in this Input Try Again");
        }
}

@Override
    public  void searchBook(String tile) {

        boolean flag = false;
        for (Books book : LibraryPojo.getBookList()) {
            if (book.getTitle().equals(tile)) {
                flag = true;
                System.out.println("Title :" + book.getTitle());
                System.out.println("Author :" + book.getAuthor());
                System.out.println("Isbn :" + book.getIsbn());
                if (book.getAvailability()) {
                    System.out.println("Availability :" + "YES");
                } else {
                    System.out.println("Availability :" + "NO");
                    System.out.println();
                }
            }
        }
        if (!flag) {
            System.out.println("No books in this Input Try Again");
        }

    }

    @Override
    public  void searchBook(int isbn) {
        boolean flag = false;
        for (Books book : LibraryPojo.getBookList()) {
            if (book.getIsbn() == isbn) {
                flag = true;
                System.out.println("Title :" + book.getTitle());
                System.out.println("Author :" + book.getAuthor());
                System.out.println("Isbn :" + book.getIsbn());
                if (book.getAvailability()) {
                    System.out.println("Availability :" + "YES");
                } else {
                    System.out.println("Availability :" + "NO");
                }
            }
        }
        if (!flag) {
            System.out.println("No books in this Input Try Again");
        }
    }


}