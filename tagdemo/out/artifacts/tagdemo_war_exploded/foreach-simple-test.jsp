<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String[] cities = {"Mumbai", "Singapore", "Philadelphia"};

    pageContext.setAttribute("myCities", cities);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="tempCity" items="${myCities}">
    ${tempCity} <br/>

</c:forEach>

</body>
</html>
