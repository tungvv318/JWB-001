<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<title>HTML Tutorial</title>
<body>
//JSTL
<%
    ArrayList<String> results = (ArrayList<String>) request.getAttribute("items");
    for (int i =0; i < results.size(); i++) {
%>
<h1>
    <%=results.get(i)%>
</h1>
<%
    }
%>

</body>
</html>