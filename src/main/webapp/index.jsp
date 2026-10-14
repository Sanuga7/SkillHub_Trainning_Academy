<%--
  Created by IntelliJ IDEA.
  User: Sanuga
  Date: 10/14/2026
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SkillHub | Home</title>
</head>
<%

    HttpSession logged = request.getSession(false);

    if (logged == null || logged.getAttribute("loggedUser") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

%>
<body>
    <h1>Welcome to SkillHub..!</h1>
</body>
</html>
