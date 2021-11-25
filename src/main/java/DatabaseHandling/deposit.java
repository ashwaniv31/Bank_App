package DatabaseHandling;

import java.sql.SQLException;

public class deposit {
    public static dbConnection theApp=new dbConnection();
    public void depositMoney(long accountNumber, long addBalance,String timeInString){
        long bal=0;
        String transactionType="Credit";
//        theApp.qry="update from wallet set balance =balance + ? where accountNumber=?";
        theApp.qry="select balance from wallet where accountNumber='"+accountNumber+"'";


        try {

            theApp.theResultSet=theApp.theStatement.executeQuery(theApp.qry);
            while (theApp.theResultSet.next())
                bal=theApp.theResultSet.getLong("balance");
                 bal=addBalance+bal;
                   System.out.println(bal);
                   updateBal(bal,accountNumber);
            bal=bal;
        }
        catch (SQLException e){
            System.out.println("Error while depositing the money"+e.getMessage());
        }

        theApp.qr2="insert into transactions (accountNumber,transactionType,transactMoney,balanceAvailable,transactionDate) values (?,?,?,?,?)";

        try {

            theApp.thePreparedStatement=theApp.dbCon.prepareStatement(theApp.qr2);

           theApp.thePreparedStatement.setLong(1,accountNumber);
            theApp.thePreparedStatement.setString(2,transactionType);
            theApp.thePreparedStatement.setLong(3,addBalance);
            theApp.thePreparedStatement.setLong(4,bal);
            theApp.thePreparedStatement.setString(5,timeInString);


            if (theApp.thePreparedStatement.executeUpdate() >0)
                System.out.println("Details are added Successfully");

        } catch (SQLException e) {
            System.out.println("Error occurs  while adding details : "+e.getMessage());
        }


    }
    public void updateBal(long bal,long accountNumber)
    {
        theApp.qry="update wallet set balance='"+bal+"' where accountNumber='"+accountNumber+"'";
        try {
            if (theApp.theStatement.executeUpdate(theApp.qry)>0)
                System.out.println("You Have Successfully Deposited The Money In Your Account Number :"+accountNumber+"\n"+
                        "Balance Available In Your Account Is : "+bal+" INR");
        }
        catch (SQLException e)
        {
            System.out.println("Error while adding depositing the money"+e.getMessage());
        }
    }

}
