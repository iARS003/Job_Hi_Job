<%@ page import="java.util.List" %>
<%@ page import="com.ars.jobhijob.entity.Job" %>

<%
    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Jobs</title>
</head>
<body>

<h2>Your Jobs</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Skills</th>
    <th>Salary</th>
    <th>Action</th>
</tr>

<% if (jobs != null) {
   for(Job j : jobs) { %>

<tr>
    <td><%= j.getJob_id() %></td>
    <td><%= j.getTitle() %></td>
    <td><%= j.getSkill_required() %></td>
    <td><%= j.getSalary() %></td>

    <td>
    	 	<a href="/company/editJob?id=<%= j.getJob_id() %>">Edit</a>
    		&nbsp;
        <a href="/company/deleteJob?id=<%= j.getJob_id() %>">Delete</a>
    </td>
</tr>

<% } } %>

</table>

<br>
<a href="/company/home">Back</a>

</body>
</html>