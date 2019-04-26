<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Customer list</title>
        <link href="/css/CustomerList.css" rel="stylesheet" type="text/css">
        
    </head>
    <body>
        <div>
            <table id="customerTable">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Balance</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                        <c:forEach var="customer" items="${customerList}">
                                <tr>
                                    <td>${customer.name}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.phoneNumber}</td>
                                    <td>${customer.balance}</td>
                                    <c:if test = "${customer.login == 1}">
                                        <td>
                                            <form action="/editing-form" method="GET">
                                                <input type="hidden" value="${customer.id}" name="customerId">
                                                <input type="submit" value="Edit">
                                            </form>

                                            <form action="/transfering-form" method="GET">
                                                <input type="hidden" value="${customer.id}" name="customerId">
                                                <input type="submit" value="Transfer">
                                            </form>

                                            <form action="/logout" method="GET">
                                                <input type="hidden" value="${customer.id}" name="customerId">
                                                <input type="submit" value="Logout">
                                            </form>
                                        </td>
                                    </c:if>
                                    <c:if test = "${customer.login == 0}">
                                        <td>
                                                <form action="/login-form" method="GET">
                                                    <input type="hidden" value="${customer.id}" name="customerId">
                                                    <input type="submit" value="Login">
                                                </form>
                                        </td>
                                    </c:if>
                                </tr>
                        </c:forEach>
                        <td><button id = add type="button" onclick="location.href = '/adding-form'">Add</button></td>
                </tbody>
            </table>
        </div>
    </body>
</html>