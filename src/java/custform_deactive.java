import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/custform_deactive")  
public class custform_deactive extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<html>");
        out.println("<head><title>List</title><style>");
        out.println("body{ background-color:skyblue; background-repeat:no repeat:Backround-size:100%;}");
        out.println("</style></head>");
        out.println("<body>");
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Customer List</h1>");  
          
        List<cust_form> list=cust_formDAO.getAllcustomer();
        out.print("<table border='3' width='100%'");  
        out.print("<tr><th>Name</th><th>Account_type</th><th>Account_no</th><th>Cust_ID</th><th>Address</th><th>Phone No</th>><th>Deactive</th></tr>");  
        for(cust_form c:list){  
         out.print("<tr><td>"+c.getFirst_name()+" "+c.getLast_name()+"</td><td>"+c.getAccount_type()+"</td><td>"+c.getAccount_no()+"</td><td>"+c.getCust_id()+"</td><<td>"+c.getAddress()+"</td><td>"+c.getPhone_no()+"</td><td><a href='custform_delet?account="+c.getAccount_no()+"'>Deacive Customer</a></tr>");  
        }  
        out.print("</table>");  
          out.println("</body>");
        out.close();  
    }  
}  
