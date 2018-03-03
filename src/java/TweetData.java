/*package sqlservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class TweetData {
void data(){
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");  
PreparedStatement ps=con.prepareStatement("insert into users(name,email,password) values(?,?,?)");  
ps.setString(1,name);  
ps.setString(2,email);  
ps.setString(3,password);  
      
int a=ps.executeUpdate();  
if(a!=0)
    System.out.println("Account created successfully");
else
    System.out.println("Account not created");
}
catch(Exception e)
{
    System.out.println(e);
}  
}
}
*/