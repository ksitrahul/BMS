import java.sql.*;
public class CLJ
{
public static boolean validate(Double account_no,String password) {
    boolean status=false;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","root");
            PreparedStatement ps =con.prepareStatement("select * from customer_singup where Account_No=? and Password=?");
ps.setDouble(1,account_no);
ps.setString(2,password);

ResultSet rs=ps.executeQuery();
status=rs.next();

}catch(Exception e) {System.out.println(e);}

return status;
}  
    }
