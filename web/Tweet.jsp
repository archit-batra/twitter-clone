<%-- 
    Document   : Tweet
    Created on : 9 Apr, 2017, 12:46:26 AM
    Author     : Archit
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="manifest" href="manifest.json">
<!--<link href="${pageContext.request.contextPath}/web/twit.css" rel="stylesheet" type="text/css" >--> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
                #wrapper { 
                    position: absolute; 
                    left: 180px; 
                    right: 10px; 
                    top: 80px; 
                    bottom: 10px; 
                } </style>
                <!--#someid { 
                  /*  position:relative;  EDIT: see comments*/
                    height:100%; 
                    width:100% 
                }-->
    
    </head>
    <body>
        <input disabled maxlength="3" size="3" value="140" id="counter">
        <form action="Tweet.jsp" method="post"><pre>
<textarea onkeyup="textCounter(this,'counter',140);" name="message" placeholder="What's happening?" rows="4" cols="50">
</textarea>
    <!--<script>
        function textCounter(field,field2,maxlimit)
{
 var countfield = document.getElementById(field2);
 if ( field.value.length > maxlimit ) {
  field.value = field.value.substring( 0, maxlimit );
  return false;
 } else {
  countfield.value = maxlimit - field.value.length;
 }
}
    </script>-->
<input type ="submit" value="Tweet">
 
</pre>
</form>
                <% 
//                try{
        String a=request.getParameter("message");
        
        String user =(String)session.getAttribute("user");
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");  
        if(a!=null&&user!=null){
        PreparedStatement ps=con.prepareStatement("insert into tweet(name,tweet) values(?,?)");  
        
        ps.setString(1,user);  
        ps.setString(2,a);  
        
        int b=ps.executeUpdate();  
        if(b!=0)
    System.out.println("Your tweet was successful");
else
    System.out.println("Tweet failed");
        }else System.out.println("a or user is null"); 
request.setAttribute("user",user);

/* out.println("Who to follow");
        //Class.forName("com.mysql.jdbc.Driver");  
        //Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");
        PreparedStatement pss=con.prepareStatement("select name from users where email!=?");
        //String n = request.getParameter("name");
        //pss.setString(1, n);
        String e = request.getParameter("email");
        pss.setString(1, e);
        ResultSet rss=pss.executeQuery();  
        while(rss.next()){  
        out.println(rss.getString("name"));*/
//                }catch (Exception e){
//      out.println("An exception occurred: " + e.getMessage());
//   }      
                %>
         
        
        
<!--<input type="hidden" name="action" value="Unfollow" onclick="this.value='Follow'">-->
<!--<input type="submit" name="Follow1" value="Follow">-->
<!--<input type="submit" name="Follow2" value="Follow">-->
<div id="wrapper">
        <!--<form action="FollowServlet" method="post">-->
        <input type="button" id="myButton1" value="Follow" onclick="change1()">
        <input type="button" id="myButton2" value="Follow" onclick="change2()">
        <input type="button" id="myButton3" value="Follow" onclick="change3()">
        <input type="hidden" name="action1" value="Follow">
        <input type="hidden" name="action2" value="Follow">
        <input type="hidden" name="action3" value="Follow">

        <!--</form>-->
</div>
<!--<p align="center">Who to follow</p>-->
<!--<input formaction="LoginDao.getdata1()">-->
<!--<form action="TweetData" method="post">-->
    
<!--</form>-->

        <script>
function textCounter(field,field2,maxlimit)
{
 var countfield = document.getElementById(field2);
 if ( field.value.length > maxlimit ) {
  field.value = field.value.substring( 0, maxlimit );
  return false;
 } else {
  countfield.value = maxlimit - field.value.length;
 }
}
function change1() // no ';' here
{
    var elem = document.getElementById("myButton1");
    if (elem.value=="Unfollow") elem.value = "Follow";
    else elem.value = "Unfollow";
    
}
function change2() // no ';' here
{
    var elem = document.getElementById("myButton2");
    if (elem.value=="Unfollow") elem.value = "Follow";
    else elem.value = "Unfollow";
    
}
function change3() // no ';' here
{
    var elem = document.getElementById("myButton3");
    if (elem.value=="Unfollow") elem.value = "Follow";
    else elem.value = "Unfollow";
    
}
</script>
        
<script src="https://www.gstatic.com/firebasejs/3.9.0/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyD21GOdRp__k6rRAURks9GSwmbmXi3sSbk",
    authDomain: "twitter-f2804.firebaseapp.com",
    databaseURL: "https://twitter-f2804.firebaseio.com",
    projectId: "twitter-f2804",
    storageBucket: "twitter-f2804.appspot.com",
    messagingSenderId: "854198312900"
  };
  firebase.initializeApp(config);
  const messaging = firebase.messaging();
  messaging.requestPermission()
.then(function() {
  console.log('Notification permission granted.');
  return messaging.getToken();
})
.then(function(token){
  console.log(token);  
})
.catch(function(err) {
  console.log('Unable to get permission to notify.',err);
})
messaging.onMessage(function(payload) {
    console.log("Message received. ", payload);
}); 

</script>
<!--<script type="text/javascript" src="app.js"></script>-->

</body>
</html>