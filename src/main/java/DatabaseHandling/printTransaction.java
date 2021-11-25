package DatabaseHandling;

import java.sql.SQLException;

public class printTransaction {
    public static dbConnection theApp=new dbConnection();
    public void miniStatement(long accountNumber, String timeInString){

    theApp.qry="select * from transactions where accountNumber='"+accountNumber+"' order by transactionDate desc limit 5";
//
        try {
            theApp.theResultSet=theApp.theStatement.executeQuery(theApp.qry);
            System.out.println("Transaction Id  Account Number  Transaction Type  Transaction Money  Balance Available" +
                    "  Transaction Date And Time ");
            while (theApp.theResultSet.next()) {
                System.out.println("     "+theApp.theResultSet.getInt("transactionId")
                        +"             "+
                         theApp.theResultSet.getLong("accountNumber")
                        +"           "+
                         theApp.theResultSet.getString("transactionType")
                        +"             "+
                        theApp.theResultSet.getLong("transactMoney")
                        +" INR            "+
                        theApp.theResultSet.getLong("balanceAvailable")
                        +" INR          "+
                        theApp.theResultSet.getString("transactionDate")
                        + " "

                );
            }
        }
        catch (SQLException e){
            System.out.println("Error While Printing The Statement"+e.getMessage());

        }


    }
}
