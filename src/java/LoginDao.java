

import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String email,String password){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");  
PreparedStatement ps=con.prepareStatement("select * from users where email=? and password=?");  
ps.setString(1,email);  
ps.setString(2,password);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}
public static void getData(String name,String email,String password){  
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
