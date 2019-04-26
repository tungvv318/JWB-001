<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Login</title>
    </head>
    <body>
            <form action="/login" method="POST">
            <fieldset>
                <legend>Login</legend>
                Email: <br>
                ${customerInfo.email} <br>
                <input name = id value="${customerInfo.id}" type="hidden"/> <br>
                Password: <br>
                <input name = pw placeholder="Enter password" type="password"/> <br>
                <input type="submit" value="Login">
            </fieldset>
        </form>
    </body>
</html>