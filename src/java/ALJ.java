import java.sql.*;
public class ALJ
{
public static boolean validate(String id,String pass) {
    boolean status=false;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","root");
            PreparedStatement ps =con.prepareStatement("select * from accountant where User_ID=? and Password=?");
ps.setString(1,id); 
ps.setString(2,pass);

ResultSet rs=ps.executeQuery();
status=rs.next();

}catch(Exception e) {System.out.println(e);}

return status;
}
}