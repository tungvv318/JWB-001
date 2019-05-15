<%@ page import="java.util.List" %>
<%@ page import="com.uetcodecamp.jwb.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <form action="/add">
        <button type="submit">Add</button>
    </form>
    <br/>
    <form action="/login">
        <button type="submit">Login</button>
    </form>
    <form onsubmit="return false ;" id = "search-engine" class="container" style="padding : 1rem ; display : flex ; flex-direction : row ;  ">
        <input id="search-text" class="form-control" placeholder="Search name..."type="text" style="width : 50vh ; margin-right : 1rem ;  " />
        <button type="submit" class="btn btn-outline-primary" style="color : white ; border-radius: 25px ; ">  Search </button>
    </form>

    <script>
        $(document).ready (function () {
            $("#search-engine").submit(function () {
                data = $("#search-text").val() ;
                $(".name-col").each(function () {
                    if (!($(this).text()).trim().includes(data.trim())) {
                        $(this).parents("tr").hide("slow",function() {
                            $(this).remove() ;
                        }) ;
                    };
                }) ;
            }) ;
        }) ;
    </script>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Balance</th>
                    <th></th>
                    <th></th>
                </tr>

                <c:forEach var="item" items="${users}">
                    <tr id="row-${item.getId() }" style="font-size : 1.2vw ; ">
                        <td> ${item.getId()} </td>
                        <td class="name-col"> ${item.getName()} </td>
                        <td> ${item.getEmail() } </td>
                        <td> ${item.getPhone() } </td>
                        <td scope="col"> ${item.getBalance() } </td>
                        <td>
                            <button onclick="Edit(${item.getId()})">Edit</button>
                        </td>
                        <td>
                            <button onclick="Delete(${item.getId()})">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>

    <script type="text/javascript">
        var url ="/delete";
        function Edit(id) {
            var urlEdit = "/edit" ;

            var data = {
                id : id
            }

            $.get(urlEdit , data , function(data , status) {

                    alert("Let's Edit !!") ;
                    window.location.assign("/edit?id=" + id.toString()) ;
            }) ;
        }
        function Delete(id) {
            if (!confirm("Do you want to delete ? ")) return ;

            var data = {
                id : id
            }

            $.post(url , data , function (data , status) {
                console.log(data) ;
                if (data == "success") {
                    $("table tbody").find("#row-" + id).hide("slow" , function() {
                        $(this).remove() ;
                    }) ;
                }
            }) ;
        }
    </script>
</body>
</html>