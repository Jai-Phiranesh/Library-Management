package Library_Management;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    static Scanner scanner = new Scanner(System.in);

    public void start(Library library) {

        System.out.println("Welcome to Library \n");
        LibraryPojo.getAccounts().add(new Admin("1", "1"));
        LibraryPojo.getAccounts().add(new Coustemer("1", "1",new ArrayList<Books>()));

        AdminActions adminActions = new AdminActions();

        CoustemerActions coustemerActions = new CoustemerActions();

        while (true) {
            System.out.println();

            System.out.println("1.Admin \n2.Coustemer \n3.Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Account account = adminActions.login();
                    if (account == null) {
                        System.out.println("Invalid Credestianls");
                    } else {
                        adminActions.operation(adminActions);
                    }
                    break;
                case 2:
                    Account accounts = coustemerActions.login();
                    if (accounts == null) {
                        System.out.println("Invalid Credestianls");
                    } else {
                        if(accounts instanceof Coustemer){
                        coustemerActions.operation((Coustemer)accounts, coustemerActions);}
                        else{
                            System.out.println("Cant Caste.");
                        }
                    }
                    break;

                case 3:

                    return;
                default:
                    break;
            }
        }
    }
}
