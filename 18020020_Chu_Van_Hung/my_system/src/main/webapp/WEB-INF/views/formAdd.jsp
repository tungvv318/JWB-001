
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Add member</title>
<style>
    form {
        border: 3px solid #f1f1f1;
        width: 21%;
    }

    /* Full-width inputs */
    input[type=text], input[type=number] {
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
    <form method = "post" action = "submitFormAdd">
        <h3>Thêm người dùng</h3><hr><br>
        <input type = "text" name = "name" placeholder="Enter name"/><br>
        <input type = "text" name = "email" placeholder="Enter email"/><br>
        <input type = "text" name = "phone" placeholder="Enter phone"/><br>
        <input type = "number" name = "balance" placeholder="Enter balance"/><br>
        <button type="submit">Add</button>
    </form>
    </center>
</body>
</html>