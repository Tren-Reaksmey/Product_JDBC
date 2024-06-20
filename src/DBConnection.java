import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ConcurrentModificationException;

public class DBConnection {
    Connection con;
    Statement stms;
    ResultSet rs;
    public DBConnection() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Product","root","pwd123");
            System.out.println("Successful");
            String CreateTable = "CREATE TABLE Product (ID INT PRIMARY KEY, Name VARCHAR(50),Price DOUBLE, Active_for_sell boolean)";
            Statement smts= con.createStatement();
            smts.execute(CreateTable);
            rs.moveToInsertRow();
            rs.updateInt("ID",1);
            rs.updateString("Name","Coke");
            rs.updateDouble("Price",2);
            rs.updateBoolean("Active_for_sell",true);

            rs.moveToInsertRow();
            rs.updateInt("ID",2);
            rs.updateString("Name","Pepsi");
            rs.updateDouble("Price",2);
            rs.updateBoolean("Active_for_sell",true);

            rs.moveToInsertRow();
            rs.updateInt("ID",3);
            rs.updateString("Name","Kizz");
            rs.updateDouble("Price",1.50);
            rs.updateBoolean("Active_for_sell",true);

            rs.moveToInsertRow();
            rs.updateInt("ID",4);
            rs.updateString("Name","Redbull");
            rs.updateDouble("Price",2);
            rs.updateBoolean("Active_for_sell",false);


            stms = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM Product";
            rs= stms.executeQuery(query);
            rs.next();


            rs.moveToCurrentRow();
            while (rs.next()) {

                //  System.out.println("ID:" + rs.getInt("Emp_Id"));
                System.out.println("ID"+rs.getInt("ID")+ "\n"+
                        "Name"+ rs.getString("Name")+ "\n"+"Price"+ rs.getDouble("Price")
                        + "Active_for_sell"+ "\n"+rs.getBoolean("Active_for_sell"));

            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
