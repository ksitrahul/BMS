import java.io.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
           String account_no=request.getParameter("account_no");
             double account=Double.parseDouble(account_no);
            String p=request.getParameter("password");
       
           if(CLJ.validate(account,p)){
out.print("Login successfully");
RequestDispatcher rd=request.getRequestDispatcher("Accountantworkspace.html");
rd.forward(request,response);
           }
else{
out.print("Something wrong please check...");
RequestDispatcher rd=request.getRequestDispatcher("cust_login.html");
rd.include(request,response);
}
out.close();
    }
}