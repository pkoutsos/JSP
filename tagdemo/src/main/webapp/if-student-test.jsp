<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*,com.luv2code.jsp.tagdemo.Student" %>

<%
    //just create some sample date
    List<Student> data = new ArrayList<>();

    data.add(new Student("John", "Doe", false));
    data.add(new Student("Maxwell", "Johnson", false));
    data.add(new Student("Petros", "Papas", true));

    pageContext.setAttribute("myStudents", data);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gold Customer</th>
    </tr>


    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>
                <c:if test="${tempStudent.goldCustomer}">
                    Special Discount
                </c:if>
                <c:if test="${not tempStudent.goldCustomer}">
                    -
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
