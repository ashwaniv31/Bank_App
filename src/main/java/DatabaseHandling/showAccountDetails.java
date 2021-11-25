package DatabaseHandling;

import java.sql.SQLException;

public class showAccountDetails {
public static dbConnection theApp=new dbConnection();

    public void displayAccountNumber(String emailId, String password){
        theApp.qry="select accountNumber,name from wallet " +
                "where emailId='"+emailId+"' AND password='"+password+"' ";
        try {
            theApp.theResultSet=theApp.theStatement.executeQuery(theApp.qry);

            while (theApp.theResultSet.next()) {
                 System.out.println("Welcome : "+theApp.theResultSet.getString("name")+"\n"+
                         "Your Account Number is: "+ theApp.theResultSet.getLong("accountNumber"));
            }
        }catch (SQLException e){
            System.out.println("Error occurs while entering the login id and password : "+e.getMessage());
        }

    }

    public void displayAccountBalance(String emailId, String password){
        theApp.qry="select balance, name from wallet " +
                "where emailId='"+emailId+"' AND password='"+password+"' ";
        try {
            theApp.theResultSet=theApp.theStatement.executeQuery(theApp.qry);

            while (theApp.theResultSet.next()) {
                System.out.println("Welcome : "+theApp.theResultSet.getString("name")+"\n"+
                        "Your Account Balance is: "+ theApp.theResultSet.getLong("balance"));
            }
        }catch (SQLException e){
            System.out.println("Error occurs while entering the login id and password : "+e.getMessage());
        }

    }



}
