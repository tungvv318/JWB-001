<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
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
            background-color: #4CAF50;
            color: white;
        }
        #customers td:last-child{
            text-align: center;
        }
        .button {
            background-color: #8a948a;
            border: none;
            color: white;
            padding: 12px 28px;
            font-size: 16px;
            margin-bottom: 19px;
            border-radius: 5px;
            cursor: pointer;
            outline: none;
        }
        .button:hover {
            background-color: #555555;
            color: white;
        }
    </style>
    <script>
        function getIDCustomerEdit(id) {
            document.getElementById("idCustomerEdit").value = id;
        }
    </script>
</head>
<body>
    <div>
        <form action="/handle" method="post">
            <input type="submit" class="button" value="Thêm" name="addCustomer">
            <table id="customers">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Balance</th>
                    <th></th>
                </tr>
                <c:forEach var="customer" items="${lstCustomer}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.balance}</td>
                        <td>
                            <input type="submit" value="Sửa" name="editCustomer" onclick="getIDCustomerEdit(${customer.id})"/>
                        </td>
                    </tr>
                </c:forEach>
                <input type="hidden" name="idCustomerEdit" id="idCustomerEdit" value="0"/>
            </table>
        </form>
    </div>
</body>
</html>