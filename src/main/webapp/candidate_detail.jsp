<%@ page import="vn.edu.iuh.fit.ongk1_2.models.Candidate" %>
<%@ page import="vn.edu.iuh.fit.ongk1_2.models.Experience" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/27/2023
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Candidate candidate = (Candidate) request.getAttribute("candidate");%>
<h1>Candidate details</h1>
<h2>Candidate ID: <%= candidate.getId()%></h2>
<h2>Name: <%= candidate.getFullName()%></h2>
<h2>Email: <%= candidate.getEmail()%></h2>
<h2>Phone: <%= candidate.getPhone()%></h2>
<h2>Experience:</h2>
<table>
    <thead>
    <tr>
        <th>Experience ID</th>
        <th>Company</th>
        <th>From Date</th>
        <th>Role</th>
        <th>To Date</th>
        <th>Work desc</th>
    </tr>
    </thead>
    <tbody>
    <%for (Experience experience: candidate.getExperiences()){%>
    <tr>
        <td><%= experience.getId()%></td>
        <td><%= experience.getCompanyName()%></td>
        <td><%= experience.getFromDate()%></td>
        <td><%= experience.getRole()%></td>
        <td><%= experience.getToDate()%></td>
        <td><%= experience.getWorkDescription()%></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
