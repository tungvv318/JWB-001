<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Transfer</title>
    </head>
    <body>
            <form action="/transfer" method="POST">
            <fieldset>
                <legend>Transfer</legend>
                ID: <br>
                <input name = receivedId placeholder="Enter receiver's ID" type="number"/> <br>
                <input type="hidden" value="${customerId}" name="sentId">
                Amount: <br>
                <input name = amount placeholder="Enter amount" type="number"/> <br>
                <input type="submit" value="Confirm">
            </fieldset>
        </form>
    </body>
</html>