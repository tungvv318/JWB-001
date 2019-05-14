<%--
  Created by IntelliJ IDEA.
  User: Bkmsx
  Date: 05/05/2019
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyen tien</title>
</head>
<body>
    <form method="post" action="/submitTransfers">
        <h2>Transfers</h2>
        <input type="number" name="id" placeholder="Enter ID"/><br/>
        <input type="number" name="balance" placeholder="Enter Balance"/><br/>
        <button type="submit">Apply</button>
        <p>${message}</p>
    </form>
</body>
</html>
