package DatabaseHandling;


import java.sql.SQLException;


public class addingDetails  {

    public static dbConnection theApp=new dbConnection();

    public void addDetails( String name,
                     long accountNumber,
                     String accountType,
                     String dob,
                     String emailId,
                     long phoneNumber,
                     long balance,
                     String address,
                     String password)
    {
            theApp.qry="insert into wallet(name, accountNumber, accountType, dateOfBirth,emailId,phoneNumber,balance,address,password) " +
                    "values(?, ?, ?, ?, ?, ?, ?, ?,?)";
                try {

                    theApp.thePreparedStatement=theApp.dbCon.prepareStatement(theApp.qry);

                    theApp.thePreparedStatement.setString(1,name);
                    theApp.thePreparedStatement.setLong(2,accountNumber);
                    theApp.thePreparedStatement.setString(3,accountType);
                    theApp.thePreparedStatement.setString(4,dob);
                    theApp.thePreparedStatement.setString(5,emailId);
                    theApp.thePreparedStatement.setLong(6,phoneNumber);
                    theApp.thePreparedStatement.setLong(7,balance);
                    theApp.thePreparedStatement.setString(8,address);
                    theApp.thePreparedStatement.setString(9,password);

                    if (theApp.thePreparedStatement.executeUpdate() >0)
                        System.out.println("Details are added Successfully");

                } catch (SQLException e) {
                    System.out.println("Error occurs  while adding details : "+e.getMessage());
                }


    }

}
