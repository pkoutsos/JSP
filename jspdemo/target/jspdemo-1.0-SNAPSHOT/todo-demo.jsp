<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Step1 : Create HTML form -->
<form action="todo-demo.jsp">
    Add new item: <input type="text" name="theItem"/>

    <input type="submit" value="Submit">
</form>

<!-- Step2 : Add new item toDoList -->
<%
    //get the TO DO items from the session
    List<String> items = (List<String>) session.getAttribute("myToDoList");

    //if the TO DO items doesn't exist, then create a new one
    if (items == null){
        items = new ArrayList<>();
        session.setAttribute("myToDoList",items);
    }

    //see if there is form data to add
    String theItem = request.getParameter("theItem");
    if (theItem != null){
        items.add(theItem);
    }

%>

<!-- Step3 : Display all "to do" items from session -->
<hr>
<b>To List Items:</b> <br/>

<ol>
    <%
        for (String temp: items){
            out.println("<li>"+temp+"</li>");
        }
    %>
</ol>

</body>
</html>
