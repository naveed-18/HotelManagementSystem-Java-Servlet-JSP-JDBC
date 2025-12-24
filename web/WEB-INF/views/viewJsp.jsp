<%@ page import="java.util.List" %>
<%@ page import="model.Reservation" %>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Room</th>
        <th>Phone</th>
        <th>Date</th>
    </tr>

<%
    List<Reservation> list =
        (List<Reservation>) request.getAttribute("reservations");

    for (Reservation r : list) {
%>
    <tr>
        <td><%= r.getId() %></td>
        <td><%= r.getName() %></td>
        <td><%= r.getRoom() %></td>
        <td><%= r.getPhone() %></td>
        <td><%= r.getDate() %></td>
    </tr>
<%
    }
%>
</table>
