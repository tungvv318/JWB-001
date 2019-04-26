<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Edit customer</title>
    </head>
    <body>
        <form:form action="/edit-customer" method="POST" modelAttribute="customerInfo">
            <fieldset>
                <legend>Edit customer</legend>
                Name: <br>
                <form:input path = "name" placeholder="Enter name" type="text"/> <br>
                Email: <br>
                <form:input path = "email" placeholder="Enter email" type="text"/> <br>
                Phone number: <br>
                <form:input path = "phoneNumber" placeholder="Enter phone number" type="text"/> <br>
                Password: <br>
                <form:input path = "password" placeholder="Enter password" type="text"/> <br>
                <input type="submit" value="Save">
            </fieldset>
        </form:form>
    </body>
</html>