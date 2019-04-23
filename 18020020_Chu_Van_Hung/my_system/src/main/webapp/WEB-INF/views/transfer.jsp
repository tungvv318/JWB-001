
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Chuyển tiền</title>
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
    <form method = "post" action = "submitTransfer">
        <h3>Chuyển tiền</h3><hr><br>
        <input type = "number" name = "id" placeholder="ID người dùng chuyển tới"/><br>
        <input type = "number" name = "balance" placeholder="Số tiền..."/><br>
        <font color = "red"><small>${messTransfer}</small></font><br>
        <button type="submit">Xác nhận</button>
    </form>
</center>
</body>
</html>