<%@ page import="vn.edu.iuh.fit.ongk1_2.enums.Roles" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.ongk1_2.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/27/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Report1: Fillter Role</h1>
<form method="post">
    <select name="selectedValue">
        <%for (Roles roles : Roles.values()) {%>
        <option value="<%= roles.toString()%>"><%= roles.toString()%></option>
        <%}%>
    </select>

    <input type="hidden" name="action" value="report1">
    <input type="submit" class="btn btn-primary" value="Filter role"></input>
</form>

<table>
    <tr>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    <%List< Candidate> candidates = (List<Candidate>) request.getAttribute("candidatesRole");%>
    <%for (Candidate candidate : candidates){%>
        <tr>
            <td><%= candidate.getFullName()%></td>
            <td><%= candidate.getEmail()%></td>
            <td><%= candidate.getPhone()%></td>

        </tr>
    <%}%>

</table>
</body>
</html>
