<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Delete Reservation</title>
</head>
<body>

<h2>Delete Reservation Status</h2>

<%
    Object msg = request.getAttribute("message");

    if (msg == null) {
%>
        <p style="color:red;">Something went wrong.</p>
<%
    } else {
        String message = msg.toString();

        if (message.toLowerCase().contains("successful")) {
%>
            <p style="color:green;"><b><%= message %></b></p>
<%
        } else {
%>
            <p style="color:red;"><b><%= message %></b></p>
<%
        }
    }
%>

<br>
<a href="<%= request.getContextPath() %>/index.html">Back to Home</a>

</body>
</html>
