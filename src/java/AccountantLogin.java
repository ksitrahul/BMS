import java.io.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
           String i=request.getParameter("id"); 
           String p=request.getParameter("pass");
       
           if(ALJ.validate(i, p)){
out.print("done");
RequestDispatcher rd=request.getRequestDispatcher("Accountantworkspace.html");
rd.forward(request,response);
           }
else{
out.print("Sorry User ID or password error");
RequestDispatcher rd=request.getRequestDispatcher("Accountant_Login.html");
rd.include(request,response);
}
out.close();
    }
}