
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Login</title>
<style>
    form {
        border: 3px solid #f1f1f1;
        width: 21%;
    }

    /* Full-width inputs */
    input[type=text], input[type=password] {
        /* width: 20%;*/
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        /* width: 10%;*/
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }
    hr{
        border-color: aqua;
    }

</style>
<body>
<br>
<center>
    <form method = "post" action = "submitLogin">
        <h3>Đăng nhập</h3><hr><br>
        <input type = "text" name = "email" placeholder="Enter email"/><br>
        <input type = "password" name = "password" placeholder="Enter password"/><br>
        <font color = "red"><small>${messLogin}</small></font><br>
        <button type="submit">Đăng nhập</button>
    </form>
</center>
</body>
</html>