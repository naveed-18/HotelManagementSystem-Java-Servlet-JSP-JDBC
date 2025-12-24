<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Get Room Number</title>
</head>
<body>

<h2>Room Details</h2>

<%
    Object obj = request.getAttribute("roomNumber");

    if (obj == null) {
%>
        <p style="color:red;">Reservation not found.</p>
<%
    } else {
        Integer roomNumber = (Integer) obj;
%>
        <p><b>Room Number:</b> <%= roomNumber %></p>
<%
    }
%>

<br>
<a href="<%= request.getContextPath() %>/index.html">Back to Home</a>

</body>
</html>
