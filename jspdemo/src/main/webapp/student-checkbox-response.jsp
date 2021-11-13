<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation Title</title>
</head>
<body>

The Student is confirmed: ${param.firstName} ${param.lastName}

<br/><br/>

Student's favourite language: ${param.favouriteLanguage}
<!-- display list of "favoriteLanguage" -->
<ul>
    <%
        String[] langs = request.getParameterValues("favouriteLanguage");

        for(String tempLang: langs){
            out.println("<li>" +tempLang+ "</li>");
        }
    %>
</ul>

</body>
</html>
