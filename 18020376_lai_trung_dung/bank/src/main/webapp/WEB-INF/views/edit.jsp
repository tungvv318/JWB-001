<%--
  Created by IntelliJ IDEA.
  User: Bkmsx
  Date: 07/05/2019
  Time: 9:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form method="post" action="/submitEdit">
        <h2>Edit User</h2>
        <input type="text" name="name" value="${name}"/><br/>
        <input type="email" name="email" value="${email}"/><br/>
        <input type="tel" name="phone" value="${phone}"/><br/>
        <input type="number" name="balance" value="${balance}"/><br/>
        <button type="submit">Apply</button>
    </form>
</body>
</html>
