<%--
  Created by IntelliJ IDEA.
  User: pkoutsos001
  Date: 13/11/2021
  Time: 2:16 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<%
    //read form data
    String favLang = request.getParameter("favouriteLanguage");

    //create the cookie
    Cookie theCookie = new Cookie("myApp.favouriteLanguage",favLang);

    //set the life spane
    theCookie.setMaxAge(60*60*24*365); //year

    //send cookie to browser
    response.addCookie(theCookie);
%>
<body>

    Thanks! We set your favourite language to : ${param.favouriteLanguage}

    <br/><br/>

    <a href="cookies-homepage.jsp">Return to homepage</a>


</body>
</html>
