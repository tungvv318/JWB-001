<%@ page import="java.util.ArrayList" %>
<%@ page import="com.uetcodecamp.jwb01.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Home</title>
<style>

    button {
        background-color: cadetblue;
        color: white;
        padding: 5px 15px;
        margin: 10px 0;
        border: none;
        cursor: pointer;
        /* width: 10%;*/
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }
    #customers {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: olivedrab;
        color: white;
    }


</style>
<body>
<form action="add">
    <button type="submit">Thêm</button>
</form>
<form action="login">
    <button type="submit">Đăng nhập</button>
</form>
<table id="customers">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Balance</th>
        <th></th>
    </tr>


<%
    ArrayList<User> results = (ArrayList<User>) request.getAttribute("items");
    for (int i =0; i < results.size(); i++) {
%>
<h1>
    <tr>
        <td><%=i+1%></td>
        <td><%=results.get(i).getName()%></td>
        <td><%=results.get(i).getEmail()%></td>
        <td><%=results.get(i).getPhone()%></td>
        <td><%=results.get(i).getBalance()%></td>
        <td><a href="edit">Edit</a> </td>
    </tr>
</h1>
<%
    }
%>
</table>
</body>
</html>