package UI;

import java.util.*;


public class UserInteraction {
    public static void hadUserInteraction(){



        do {
            Scanner sc= new Scanner(System.in);
            UiOperations.askUserForInput();
            int userChoice=sc.nextInt();
            sc.nextLine();

            switch (userChoice)
            {
                case 1:
                {
                    UiOperations.createAccount();
                    break;
                }

                case 2: {
                    UiOperations.showAccountDetails();
                    break;

                }

                case 3:
                {

                    UiOperations.depositBalance();
                    break;
                }

                case 4:
                {
                    UiOperations.withdraw();
                    break;

                }

                case 5:
                {
                    UiOperations.fundTransfer();

                }

                case 6:
                {
                    UiOperations.printTransactionStatement();
                }

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        while (true);

    }
}
