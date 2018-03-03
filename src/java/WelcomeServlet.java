

import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*; 
  
public class WelcomeServlet extends HttpServlet {    
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");  
        String e = request.getParameter("email");
        PreparedStatement ps=con.prepareStatement("select name from users where email=?");
        ps.setString(1, e);
        ResultSet rs=ps.executeQuery();  
         
        if(rs.next())  
        {String d = rs.getString(1);
        out.println("Welcome "+d);
        HttpSession session=request.getSession(); 
        session.setAttribute("user",d);
        }
        else
        out.print("Exit");
        
        //out.println("<input type=\"text\" maxlength=\"140\" placeholder=\"What's happening?\" required>\n");
        //out.println("<input type=\"submit\" value=\"Tweet\">\n");
        out.println("Who to follow");
        //Class.forName("com.mysql.jdbc.Driver");  
        //Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");
        PreparedStatement pss=con.prepareStatement("select name from users where email!=?");
        //String n = request.getParameter("name");
        //pss.setString(1, n);
        pss.setString(1, e);
        ResultSet rss=pss.executeQuery();  
        while(rss.next()){  
        out.println(rss.getString("name"));  
//        out.println("<input type=submit name=\"Follow\" value=\"Follow\">");
        //System.out.println(rss.getString("name"));
        }
        
        //out.print("Exit");
        con.close();
        
        //catch(Exception es){System.out.println(es);}
        
//LoginDao.getData1();
        
        RequestDispatcher rd=request.getRequestDispatcher("Tweet.jsp");
        rd.include(request,response);
        
    }
    catch(Exception es)
    {System.out.println(es);}
} 
    
    }  
  
