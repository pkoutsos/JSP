<%--
  Created by IntelliJ IDEA.
  User: pkoutsos001
  Date: 13/11/2021
  Time: 10:08 π.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Hello World</h3>

<%
    for (int i = 1; i <= 5; i++) {
        out.println("<br/> Hello world" + i);
    }
%>
</body>
</html>
