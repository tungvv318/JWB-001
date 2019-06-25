<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
            float: left;
        }
        .button:hover {
            background-color: #555555;
            color: white;
        }
        form.example input[type=text] {
            padding: 10px;
            font-size: 17px;
            border: 1px solid grey;
            width: 80%;
            background: #f1f1f1;
            border-radius: 3px;
        }

        form.example button {
            float: right;
            padding: 10px;
            background: #8a948a;
            color: white;
            font-size: 17px;
            border: 1px solid grey;
            border-left: none;
            cursor: pointer;
            width: 100px;
            border-radius: 3px;
        }

        form.example button:hover {
            background-color: #555555;
        }

        form.example::after {
            content: "";
            clear: both;
            display: table;
        }
        .setBoder{
            background-color: #8a948a;
            border: none;
            color: white;
            padding: 7px 20px;
            border-radius: 3px;
            cursor: pointer;
        }
        .setBoder:hover{
            background-color: #555555;
            color: white;
        }
        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }
        .pagination{
            float: right;
            margin-top: 30px;
        }
        .pagination a.active {
            background-color: dodgerblue;
            color: white;
        }
        .pagination a:hover:not(.active) {background-color: #ddd;}
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function del(r, id) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("customers").deleteRow(i);
            $.post("/handle-delete-customer", {
                id
            });
        }
    </script>
</head>
<body>
    <div class="topnav">
        <div class="clear-fix">
            <form action="/handle-search" method="get" class="example">
                <button type="submit"><i class="fa fa-search"></i></button>
                <input type="text" placeholder="Search.." name="search" style="max-width: 300px;
        float: right;" id="mySearch" onkeyup="myFunction()">
            </form>
            <form action="/handle-add" method="get" style="display: inline-block;margin-top: -44px;">
                <input type="submit" class="button" name="addCustomer" value="Thêm">
            </form>
        </div>
        <table id="customers">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Balance</th>
                <th colspan="2" style="text-align: center;">Lựa chọn</th>
            </tr>
            <c:forEach var="customer" items="${lstCustomer.content}">
                <tr class="myMenu">
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.balance}</td>
                    <td align="center">
                        <input type="submit" class="setBoder" value="Xóa" name="deleteCustomer" onclick="del(this, '${customer.id}')"/>
                    </td>
                    <td align="center">
                        <form action="/handle-edit" method="get">
                            <input type="hidden" name="idCustomerEdit" value="${customer.id}">
                            <input type="submit" class="setBoder" name="editCustomer" value="Sửa">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="pagination">
        <a href="#">&laquo;</a>
        <c:forEach var = "i" begin="1" end="${amoutPage}">
            <a href="/?page=${i-1}">${i}</a>
        </c:forEach>
        <a href="#">&raquo;</a>
    </div>

<script>
    function myFunction() {
        var input, filter, tr, td, i;
        input = document.getElementById("mySearch");
        filter = input.value.toUpperCase();
        tr = document.getElementsByClassName("myMenu");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
</script>

</body>
</html>