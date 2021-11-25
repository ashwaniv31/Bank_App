package DatabaseHandling;


import java.sql.*;


public class dbConnection {
    public static final String URLTOCONNECT = "jdbc:mysql://localhost:3306/bank_wallet_app_db";

    public static final String USERNAME = "root";

    public static final String USERPASSWORD = "root";

    String qry,qr1,qr2,qr3,qr4;

    Connection dbCon;

    Statement theStatement;

    PreparedStatement thePreparedStatement;

    ResultSet theResultSet;

    public dbConnection(){
        try {
//          Load the DB Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, USERPASSWORD);

            theStatement = dbCon.createStatement();

//			System.out.println("Connected to the database now...");



        } catch (ClassNotFoundException e) {
            System.out.println("Can't load the driver : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Can't connect to the database : " + e.getMessage());
        }
    }
}
