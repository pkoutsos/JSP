<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<!-- read the favourite programming language cookie -->
<%
    //the default ... if there are no cookies
    String favLang = "Java";

    //get the cookies from the browser request
    Cookie[] theCookies = request.getCookies();

    //find our favourite language cookie
    if (theCookies != null) {

        for (Cookie tempCookie : theCookies) {

            if ("myApp.favouriteLanguage".equals(tempCookie.getName())) {
                favLang = tempCookie.getValue();
                break;
            }
        }
    }
%>

<body>
<h3>Training Portal</h3>
<!-- now show a personalized page ... use the "favLang" -->

<!-- show new books for this lang -->
<h4>New Books for <%= favLang %>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<!-- show latest reports for this lang -->
<h4>Latest reports for <%= favLang %>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>

<!-- show hot jobs for this lang -->
<h4>Hot Jobs for <%= favLang %>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>
<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>

</body>
</html>
