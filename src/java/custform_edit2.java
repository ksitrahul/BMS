import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/custform_edit2")  
public class custform_edit2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String account_type=request.getParameter("account_type");
        String first_name=request.getParameter("first_name");
        String last_name=request.getParameter("last_name");
          String address=request.getParameter("address");
           String city=request.getParameter("city");
            String state=request.getParameter("state");
            String pincode=request.getParameter("pincode");
            String phone_no=request.getParameter("phone_no");
            String alt_no=request.getParameter("alt_no");
            String gender=request.getParameter("gender");
              String dob=request.getParameter("dob");
              String marital_status=request.getParameter("marital_status");
              String account_no=request.getParameter("account_no");
              double account=Double.parseDouble(account_no);
              String cust_id=request.getParameter("cust_id");    
          
        cust_form c=new cust_form();  
c.setAccount_type(account_type); 
c.setFirst_name(first_name);
c.setLast_name(last_name);
c.setAddress(address);
c.setCity(city);
c.setState(state);
c.setPincode(pincode);
c.setPhone_no(phone_no);
c.setAlt_no(alt_no);
c.setGender(gender);
c.setDob(dob);
c.setMarital_status(marital_status);
c.setAccount_no(account);
c.setCust_id(cust_id);         
       int status=cust_formDAO.update(c);
        if(status>0){  
            response.sendRedirect("custform_view");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  