<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.sql.*"
%>

<%
String email="",password="";
if(request.getParameter("email")!=null){
    email=request.getParameter("email");
}
if(request.getParameter("password")!=null){
    password=request.getParameter("password");
}
%>

<%
Connection con=null;
PreparedStatement pst=null;
ResultSet re=null;
String url="jdbc:mysql://localhost:3306/test";
String Driver="com.mysql.jdbc.Driver";
String user="root";
String pass="";

Class.forName(Driver);
con=DriverManager.getConnection(url,user,pass);
String sql="select * from users where email = ? and password = ?";
try{
pst=con.prepareStatement(sql);
pst.setString(1,email);
pst.setString(2,password);
re=pst.executeQuery();
if(re.next()){
    out.println("CONNECTED!!!");
}else{
    out.println("LOGIN FAILED!!!");
}
} catch(Exception e){

    out.println("ERROR CONNECTING");
}
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="actualsession" class="beans.session" scope="session"/>
        <jsp:setProperty name="actualsession" property="email" value="<%=email%>"/>
        <jsp:setProperty name="actualsession" property="password" value="<%=password%>"/>

  <%--
        <jsp:getProperty name="actualsession" property="email"/><br/>
        <jsp:getProperty name="actualsession" property="password"/><br/>
  --%>


    </body>

</html>