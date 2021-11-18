<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>FooBar University</h2>
    </div>
</div>

<div id="container">
    <h3>Update student</h3>

    <form action="StudentControllerServlet" method="get">

        <input type="hidden" name="command" value="UPDATE"/>

        <input type="hidden" name="studentId" value="${THE_STUDENT.id}"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><input type="text" name="firstName"
                           value="${THE_STUDENT.firstName}"/></td>

            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><input type="text" name="lastName"
                           value="${THE_STUDENT.lastName}"/></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"
                           value="${THE_STUDENT.email}"/></td>
            </tr>

            <td><label>Save</label></td>
            <td><input type="submit" value="Save" class="save"/></td>


            </tbody>
        </table>

        <div style="clear: both;">
            <p>
                <a href="StudentControllerServlet">Back to List</a>
            </p>
        </div>
    </form>
</div>


</body>
</html>














