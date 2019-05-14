<%--
  Created by IntelliJ IDEA.
  User: Bkmsx
  Date: 04/05/2019
  Time: 10:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <center>
        <form method="post" action="submitAdd">
            <label>Enter name: </label>
            <input type="text" name="name" placeholder="Enter name"/><br/>
            <label>Enter email: </label>
            <input type="email" name="email" placeholder="Enter email"/><br/>
            <label>Enter phone: </label>
            <input type="tel" name="phone" placeholder="Enter phone"/><br/>
            <label>Enter balance: </label>
            <input type="number" name="balance" placeholder="Enter balance"/><br/>
            <button type="submit">Add</button>
        </form>
    </center>

</body>
</html>
