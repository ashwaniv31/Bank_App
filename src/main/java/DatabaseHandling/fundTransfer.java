package DatabaseHandling;

import java.sql.SQLException;

public class fundTransfer {
    public static dbConnection theApp=new dbConnection();

    public void fundToTransfer(long accountNumber1,long accountNumber2,long fundTransferAmmount, String timeInString){
        long bal=0;
        String transactionType="Debit";

        theApp.qry="select balance from wallet where accountNumber='"+accountNumber1+"'";

        try {

            theApp.theResultSet = theApp.theStatement.executeQuery(theApp.qry);
            while (theApp.theResultSet.next())
                bal = theApp.theResultSet.getLong("balance");
            if (bal>=fundTransferAmmount) {
                bal = bal - fundTransferAmmount;
                System.out.println(bal);

                balnceAfterTransferFund(bal, accountNumber1);


                theApp.qr2="insert into transactions (accountNumber,transactionType,transactMoney,balanceAvailable,transactionDate) values (?,?,?,?,?)";

                try {

                    theApp.thePreparedStatement=theApp.dbCon.prepareStatement(theApp.qr2);

                    theApp.thePreparedStatement.setLong(1,accountNumber1);
                    theApp.thePreparedStatement.setString(2,transactionType);
                    theApp.thePreparedStatement.setLong(3,fundTransferAmmount);
                    theApp.thePreparedStatement.setLong(4,bal);
                    theApp.thePreparedStatement.setString(5,timeInString);


                    if (theApp.thePreparedStatement.executeUpdate() >0)
                        System.out.println("Details are added Successfully");

                } catch (SQLException e) {
                    System.out.println("Error occurs  while adding details : "+e.getMessage());
                }

                balanceTransferToTheAccount(accountNumber2,fundTransferAmmount,timeInString);

            }
            else
            {
                System.out.println("You Don't have enough balance in your account. ");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error"+e.getMessage());
        }



    }

    public void balanceTransferToTheAccount(long accountNumber2,long fundTransferAmmount,String timeInString){
        long bal=0;
        String transactionType="Credit";
        theApp.qry="select balance from wallet where accountNumber='"+accountNumber2+"'";

        try {

            theApp.theResultSet = theApp.theStatement.executeQuery(theApp.qry);
            while (theApp.theResultSet.next())
                bal = theApp.theResultSet.getLong("balance");
            bal=bal+fundTransferAmmount;
            System.out.println("Updated Balance"+bal);

            theApp.qr2="insert into transactions (accountNumber,transactionType,transactMoney,balanceAvailable,transactionDate) values (?,?,?,?,?)";

            try {

                theApp.thePreparedStatement=theApp.dbCon.prepareStatement(theApp.qr2);

                theApp.thePreparedStatement.setLong(1,accountNumber2);
                theApp.thePreparedStatement.setString(2,transactionType);
                theApp.thePreparedStatement.setLong(3,fundTransferAmmount);
                theApp.thePreparedStatement.setLong(4,bal);
                theApp.thePreparedStatement.setString(5,timeInString);


                if (theApp.thePreparedStatement.executeUpdate() >0)
                    System.out.println("Details are added Successfully");

            } catch (SQLException e) {
                System.out.println("Error occurs  while adding details : "+e.getMessage());
            }

            fundTransferUpdate(bal,accountNumber2);



            }


        catch (SQLException e)
        {
            System.out.println("Error"+e.getMessage());
        }

    }


    public void fundTransferUpdate( long bal, long accountNumber2){

        theApp.qry="update wallet set balance='"+bal+"' where accountNumber='"+accountNumber2+"'";
        try {
            if (theApp.theStatement.executeUpdate(theApp.qry)>0)
                System.out.println("Successfully Transfered");
        }
        catch (SQLException e)
        {
            System.out.println("Error while transfering the money"+e.getMessage());
        }
    }




    public void balnceAfterTransferFund( long bal, long accountNumber1){

        theApp.qry="update wallet set balance='"+bal+"' where accountNumber='"+accountNumber1+"'";
        try {
            if (theApp.theStatement.executeUpdate(theApp.qry)>0)
                System.out.println("You Have Successfully Transfered The Money From Your Account Number :"+accountNumber1+"\n"+
                        "Balance Available In Your Account Is : "+bal+" INR");
        }
        catch (SQLException e)
        {
            System.out.println("Error while adding depositing the money"+e.getMessage());
        }
    }





}


