<%--
  Created by IntelliJ IDEA.
  User: Bkmsx
  Date: 05/05/2019
  Time: 10:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile User</title>
</head>
<body>
    <h2>Profile</h2>
    <form action="transfers">
        <p>Name: ${name}</p>
        <p>Email: ${email}</p>
        <p>Phone: ${phone}</p>
        <p>Balace: ${balance} VND</p>
        <button type="submit">Transfers</button>
    </form>
</body>
</html>
