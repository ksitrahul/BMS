import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/custform")
public class custform extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String account_type=request.getParameter("account_type");
        String currency=request.getParameter("currency");
        String title=request.getParameter("title");
        String first_name=request.getParameter("first_name");
        String middle_name=request.getParameter("middle_name");
        String last_name=request.getParameter("last_name");
         String contact_no=request.getParameter("contact_no"); 
         String email_id=request.getParameter("email_id");
          String address=request.getParameter("address");
           String city=request.getParameter("city");
            String state=request.getParameter("state");
             String postal=request.getParameter("postal");
              String country=request.getParameter("country");
              String citizenship=request.getParameter("citizenship");
              String dob=request.getParameter("dob");
              String marital_status=request.getParameter("marital_status");
              String language=request.getParameter("language");
              String occupation=request.getParameter("occupation");
              String account_no=request.getParameter("account_no");
              String cust_id=request.getParameter("cust_id");
              
              
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","root");
               PreparedStatement ps =con.prepareStatement("insert into cust_form values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,account_type); 
ps.setString(2,currency);
ps.setString(3,title);
ps.setString(4,first_name);
ps.setString(5,middle_name);
ps.setString(6,last_name);
ps.setString(7,contact_no);
ps.setString(8,email_id);
ps.setString(9,address);
ps.setString(10,city);
ps.setString(11,state);
ps.setString(12,postal);
ps.setString(13,country);
ps.setString(14,citizenship);
ps.setString(15,dob);
ps.setString(16,marital_status);
ps.setString(17,language);
ps.setString(18,occupation);
ps.setString(19,account_no);
ps.setString(20,cust_id);


int i=ps.executeUpdate();
if(i>0)
    out.print("You are Successfully registered");
RequestDispatcher rd=request.getRequestDispatcher("Accountantworkspace.html");
rd.forward(request,response);

        } catch (Exception e2) {System.out.println(e2); }out.print("You are not registered");
        out.close();
        
    }
}