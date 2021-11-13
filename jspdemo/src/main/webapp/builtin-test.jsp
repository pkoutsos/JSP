<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>JSP Built-In Objects</h3>

Request user agent: <%= request.getHeader("User-Agent")%>

<br/><br/>

Request language: <%= request.getLocale()%>
</body>
</html>
