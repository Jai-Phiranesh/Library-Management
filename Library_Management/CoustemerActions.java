package Library_Management;

import java.util.Scanner;

public class CoustemerActions implements CoustemerInterface {
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void operation(Coustemer account, CoustemerActions coustemerActions) {
        while(true){
        System.out.println();
        System.out.println("1.SearchBook \n2.Return Book  \n3.Borrow a Book \n4.Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {

            case 1:
                if (LibraryPojo.getBookList().isEmpty()) {
                    System.out.println("No Books");
                    break;
                }

                System.out.println("1.Search by Title\n2.Search by Isbn");
                int choiceSearch = Integer.parseInt(scanner.nextLine());

                if (choiceSearch == 1) {
                    System.out.println("Enter The Title:");
                    String title = scanner.nextLine();
                    coustemerActions.searchBook(title);
                } else if (choiceSearch == 2) {
                    System.out.println("Enter The ISBN Number:");
                    int number = Integer.parseInt(scanner.nextLine());
                    coustemerActions.searchBook(number);

                } else {
                    System.out.println("Invalid Input Try Again");
                }
                break;

            case 2:
                coustemerActions.returnBook(account);
                break;

            case 3:
                coustemerActions.borrowBook(account);
                break;

            case 4:
                System.out.println("Existing......");
                return;

            default:
                System.out.println("Invalid Input Try Again..");

        }
    }
}

    @Override
    public Account login() {
        System.out.println("Enter the User Name:");
        String username = scanner.nextLine();

        System.out.println("Enter the Password");
        String password = scanner.nextLine();

        for (Account accout : LibraryPojo.getAccounts()) {
            if (accout instanceof Coustemer) {
                if (accout.getUserName().equals(username) && accout.getPassword().equals(password)) {
                    return accout;
                }
            }

        }
        return null;
    }

    @Override
    public void borrowBook(Coustemer coustemer) {

        if (LibraryPojo.getBookList().isEmpty()) {
            System.out.println("No Books");
            return;
        }

        System.out.println("Enter Book Title To Borrow");
        String title = scanner.nextLine();
        Books currentbook = null;

        for (Books book : LibraryPojo.getBookList()) {
            if (book.getTitle().equals(title)) {

                if (book.getAvailability()) {
                    currentbook = book;
                }
            }
        }
        if (currentbook == null) {
            System.out.println("No Books Available In this Title");
        } else {
            System.out.println("Availability: " + "YES");
            System.out.println("Enter (Y) to Borrow");
            String choiceY = scanner.nextLine();
            if (choiceY.toLowerCase().equals("y")) {
                System.out.println("SuccessFully Borrowed Kindly return within Time");
                coustemer.getBorrowBooks().add(currentbook);
                currentbook.setAvailability(false);
            }
        }

    }

    @Override
    public void searchBook(String tile) {

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
    public void searchBook(int isbn) {
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

    @Override
    public void returnBook(Coustemer coustemer) {
        if(coustemer.getBorrowBooks().isEmpty()){
            System.out.println("No Borrowings");
            return;
        }

        for(Books books : coustemer.getBorrowBooks()){
            System.out.println("Your Borrowings..");
            System.out.println(books.getTitle()+"  Isbn: "+books.getIsbn());
        }

        System.out.println("Enter The Book Isbn To Return:");
        int isbn = Integer.parseInt(scanner.nextLine());
        Books booktoRemove = null;
        for(Books books : coustemer.getBorrowBooks()){
            if(books.getIsbn()==isbn){
                int index = LibraryPojo.getBookList().indexOf(books);
                LibraryPojo.getBookList().get(index).setAvailability(true);
                booktoRemove = books;
                System.out.println("SuccessFully Returned");
            }
        }
        if(booktoRemove==null){
            System.out.println("No Books In the Borrowing List...");
        }
        else{
            coustemer.getBorrowBooks().remove(booktoRemove);
        }

    }

}
