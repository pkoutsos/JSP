<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="data" value="luv2code" />
    Length of the String <b>${data}</b> : ${fn:length(data)}

<br/><br/>

Uppercase version of the String <b>${data}</b> : ${fn:toUpperCase(data)}

<br/><br/>

Does the string  <b>${data}</b>  start with <b>luv</b>?: ${fn:startsWith(data, "luv")}
</body>
</html>
