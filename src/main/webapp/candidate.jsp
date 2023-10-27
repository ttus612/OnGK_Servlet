<%@ page import="vn.edu.iuh.fit.ongk1_2.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/27/2023
  Time: 2:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Candidate Page</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>fullName</th>
        <th>email</th>
        <th>phone</th>
        <th>View</th>
    </tr>
    </thead>
    <tbody>
    <% List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates"); %>
    <% if (candidates != null) { %>
    <% for (Candidate candidate : candidates) { %>
    <tr>
        <td><%= candidate.getId()%></td>
        <td><%= candidate.getFullName()%></td>
        <td><%= candidate.getEmail()%></td>
        <td><%= candidate.getPhone()%></td>
        <td><a href="controller?action=candidateDetails&id=<%= candidate.getId()%>">View</a></td>
    </tr>
    <% } %>
    <% } %>

    </tbody>
</table>
</body>
</html>
