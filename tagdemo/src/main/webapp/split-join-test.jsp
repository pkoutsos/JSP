<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:set var="data" value="Singapore,Tokyo,Mumbai,London"/>

<h3>Split Demo</h3>

<c:set var="citiesArray" value="${fn:split(data, ',')}" />

<c:forEach var="tempCity" items="${citiesArray}" >
    ${tempCity} <br/>
</c:forEach>

<h3>Join Demo</h3>

<c:set var="fun" value="${fn:join(citiesArray, '*')}" />

<c:forEach var="tempCity" items="${fun}" >
    ${tempCity}
</c:forEach>


</body>
</html>



