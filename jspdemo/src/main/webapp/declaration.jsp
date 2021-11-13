<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: pkoutsos001
  Date: 13/11/2021
  Time: 10:13 π.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
  String makeItLower (String data){
      return data.toLowerCase();
  }
%>

Lower case "Hello World ":<%=makeItLower("Hello World")%>

</body>
</html>
