/*
import java.io.IOException;  
import java.io.PrintWriter;    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class TweetServlet extends HttpServlet {  
    
    @Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{    
    response.setContentType("text/html");  
    try {
        String a=request.getParameter("message");
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");  
        PreparedStatement ps=con.prepareStatement("insert into tweet(name,tweet) values(?,?)");  
        String user =(String)request.getAttribute("user");
        ps.setString(1,user);  
        ps.setString(2,a);  
        
        int b=ps.executeUpdate();  
        }
        catch(Exception e)
       {
       System.out.println(e);
       }
}
}
*/