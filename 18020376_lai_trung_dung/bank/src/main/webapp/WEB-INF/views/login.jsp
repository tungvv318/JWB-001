<%--
  Created by IntelliJ IDEA.
  User: Bkmsx
  Date: 05/05/2019
  Time: 8:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form method="post" action="/submitLogin">
        <input type="email" name="email" placeholder="Enter email"/><br/>
        <input type="password" name="password" placeholder="Enter password"/><br/>
        <p>${messLogin}</p>
        <button type="submit">Login</button>
    </form>
</body>
</html>
