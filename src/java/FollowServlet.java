/*

import java.io.IOException;  
import java.io.PrintWriter;    
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class FollowServlet extends HttpServlet {  
    
    @Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{    
    response.setContentType("text/html");  
    try (PrintWriter out = response.getWriter()) {
        String a=request.getParameter("action1");
        String n, e, p;
        if("Follow".equals(a))
        {   
        e = request.getParameter("myButton1");
        
        if(LoginDao.validate(e,p)){
        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
        rd.forward(request,response);
        }
        else{
        out.print("Sorry email or password error");
        RequestDispatcher rd=request.getRequestDispatcher("Login.html");
        rd.include(request,response);
        }       
        }
        else if("Signup".equals(a))
        {   
        e = request.getParameter("email");
        p = request.getParameter("password"); 
                                             //if mail and pass match select query else insert query
        if(LoginDao.validate(e,p)){
        out.print("It looks like you're already a user. Kindly sign in to continue. ");
        RequestDispatcher rd=request.getRequestDispatcher("Login.html");
        rd.include(request,response);
        }
        else{
        n = request.getParameter("name");
        LoginDao.getData(n,e,p);
        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
        rd.include(request,response);
        }
        }
        }
    }
}
*/