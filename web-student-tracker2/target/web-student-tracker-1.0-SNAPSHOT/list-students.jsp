<%@ page import="java.util.*,com.luv2code.web.jdbc.*" %>
<%@ page import="com.pan.model.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Tracker App</title>
</head>
<%
    //get the students from the request object (sent by servlet)
    List<Student> theStudents =
            (List<Student>) request.getAttribute("STUDENT_LIST");
%>


<body>

        <div id="wrapper">
            <div id="header">
                <h2>Foobar University</h2>
            </div>
        </div>

        <div id="container">

            <div id="content">
                <table>

                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>

                    <% for (Student tempStudent: theStudents) { %>

                    <tr>
                        <td> <%= tempStudent.getFirstName() %></td>
                        <td> <%= tempStudent.getLastName() %></td>
                        <td> <%= tempStudent.getEmail() %></td>
                    </tr>

                    <% } %>

                </table>

            </div>
        </div>

</body>
</html>
