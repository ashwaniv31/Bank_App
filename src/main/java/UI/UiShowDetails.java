package UI;
import Entity.BankDetails;
import Main.App;
import DatabaseHandling.*;

import java.util.Scanner;

public class UiShowDetails {


    public static void askUserForLoginCredentialForAccountNumber(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Your LoginId:");
        String logInId= sc.nextLine();

        System.out.println("Please Enter Your Password");
        String password= sc.nextLine();

        showAccountDetails show=new showAccountDetails();
        show.displayAccountNumber(logInId,password);

    }

    public static void askUserForLoginCredentialForCheckBalance(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Your LoginId:");
        String logInId= sc.nextLine();

        System.out.println("Please Enter Your Password");
        String password= sc.nextLine();

        showAccountDetails show=new showAccountDetails();
        show.displayAccountBalance(logInId,password);


    }


}
