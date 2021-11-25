package UI;

import java.util.*;
import Main.App;
import Entity.BankDetails;
import DatabaseHandling.*;
import java.time.LocalDateTime;


public class UiOperations {




    public static void createAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name=sc.nextLine();

        long min=90000000l;
        long max=99999999l;
        long accountNumber=(long)Math.floor(Math.random()*(max-min+1)+min);

        System.out.println("Please enter your account type you want to open:");
        String accontType=sc.nextLine();

        System.out.println("Please enter your date of birth:");
        String dob=sc.nextLine();

        System.out.println("Please enter your emailId:");
        String emailId=sc.nextLine();

        System.out.println("Please enter your phone number:");
        long phoneNumber=sc.nextLong();
        sc.nextLine();

        long balance=0l;

        System.out.println("Please enter your address:");
        String address=sc.nextLine();

        System.out.println("Enter password for your account ");
        String password=sc.nextLine();

        addingDetails add=new addingDetails();
        add.addDetails(name,accountNumber,accontType,dob,emailId,phoneNumber,balance,address,password);


    }



    public static void showAccountDetails(){

        Scanner sc =new Scanner(System.in);
       do {
           System.out.println("Please choose from the following:\n" +
                   "1.To Display Your Account Number\n" +
                   "2. To Check Your Account Balance\n" +
                   "3. Exit");

           int userDetailChoice = sc.nextInt();
           sc.nextLine();


           switch (userDetailChoice) {

               case 1:
                   UiShowDetails.askUserForLoginCredentialForAccountNumber();
                   break;

               case 2:
                   UiShowDetails.askUserForLoginCredentialForCheckBalance();
                   break;

               case 3:
                   System.exit(0);
               default:
                   System.out.println("Invalid Option Choosen");
           }
       }while (true);

    }

    public static void depositBalance(){

        Scanner sc=new Scanner(System.in);

        System.out.println("Eneter Your Account Number In Which You Want To Deposit The Money:");
        long accountNumber= sc.nextLong();
        sc.nextLine();
        System.out.println("Enter The Ammount That You Wnat To Deposit In Your Account Number :"+accountNumber);
        long addBalance= sc.nextLong();
        sc.nextLine();
        LocalDateTime time=LocalDateTime.now();
        String timeInSTring=time.toString();


        deposit dep=new deposit();
        dep.depositMoney(accountNumber,addBalance,timeInSTring);
    }

    public static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Eneter Your Account Number In Which You Want To Withdraw The Money:");
        long accountNumber= sc.nextLong();
        sc.nextLine();
        UiShowDetails.askUserForLoginCredentialForAccountNumber();

        System.out.println("Enter The Ammount That You Wnat To Withdraw In Your Account Number :"+accountNumber);
        long withBalance= sc.nextLong();
        sc.nextLine();

        LocalDateTime time=LocalDateTime.now();
        String timeInSTring=time.toString();

        withdrawBal withBal=new withdrawBal();
        withBal.withdrawMoney(accountNumber,withBalance,timeInSTring);
    }

    public static void fundTransfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number From Which You Want To Do The Fund Transfer");
        long accountNumber1= sc.nextLong();;
        sc.nextLine();
        UiShowDetails.askUserForLoginCredentialForAccountNumber();

        System.out.println("Enter The Account Number In Which You Want To Do The Fund Transfer");
        long accountNumber2= sc.nextLong();;
        sc.nextLine();

        System.out.println("Eneter The Ammount You Want To Transfer: To Account Number ="+accountNumber2);
        long transferBalance= sc.nextLong();
        sc.nextLine();

        LocalDateTime time=LocalDateTime.now();
        String timeInSTring=time.toString();

        fundTransfer theFundTransfer=new fundTransfer();
        theFundTransfer.fundToTransfer(accountNumber1,accountNumber2,transferBalance,timeInSTring);
    }



public static void printTransactionStatement()
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter The Account Number ");
    long accountNumber= sc.nextLong();
    sc.nextLine();

    UiShowDetails.askUserForLoginCredentialForAccountNumber();

    LocalDateTime time=LocalDateTime.now();
    String timeInSTring=time.toString();

    printTransaction thePrintTransaction=new printTransaction();
    thePrintTransaction.miniStatement(accountNumber,timeInSTring);



}



    public static void askUserForInput(){
        System.out.println("Hey there,\n" +
                "Please choose from the following:\n" +
                "1. Create Account ***\n" +
                "2. Show Balance ***\n" +
                "3. Deposit ***\n" +
                "4. Withdraw ***\n" +
                "5. Fund Transfer ***\n" +
                "6. Print Tansaction***\n"+
                "7. Exit ***\n"
        );

    }

}
