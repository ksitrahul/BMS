import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/cust_singup")
public class cust_singup extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String n= req.getParameter("name");
        String a=req.getParameter("account_no");
   //  double acount_no=Double.parseDouble(account_no);
     String c_id= req.getParameter("cust_id");
     String phone_no= req.getParameter("phone_no");
     String pass= req.getParameter("password");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","root");
            PreparedStatement ps =con.prepareStatement("insert into customer_singup values(?,?,?,?,?)");
            ps.setString(1,n);
           ps.setString(2, a);
            ps.setString(3,c_id);
            ps.setString(4,phone_no);
            ps.setString(5,pass);
            int i=ps.executeUpdate();
            if(i>0)
            {
                pw.println();
                pw.println("You are Sucessfully Register !!");
                   req.getRequestDispatcher("cust_login.html").include(req, res); 
            }
        }
            catch (Exception r)
                    {
                    System.out.println(r);
                    }
            pw.close();
        }
}