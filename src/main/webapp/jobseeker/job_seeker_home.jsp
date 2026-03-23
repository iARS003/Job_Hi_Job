<%@ page import="java.util.List" %>
<%@ page import="com.ars.jobhijob.entity.Job" %>
<%@ page import="com.ars.jobhijob.entity.JobSeeker" %>

<%
    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
    JobSeeker js = (JobSeeker) request.getAttribute("jobSeeker");
    String applyMessage = (String) session.getAttribute("applyMessage");
    if (applyMessage != null) session.removeAttribute("applyMessage");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Job Seeker Home</title>
</head>
<body>

<h2>Welcome, <%= js != null ? js.getName() : "Job Seeker" %></h2>

<p>Email: <%= js != null ? js.getEmail() : "" %></p>
<p>Phone: <%= js != null && js.getPhone_no() != null ? js.getPhone_no() : "Not set" %></p>
<p>Skills: <%= js != null && js.getSkills() != null ? js.getSkills() : "Not set" %></p>
<p>Experience: <%= js != null ? js.getExperience() + " years" : "" %></p>

<br>
<a href="/jobseeker/editProfile">Edit Profile</a>
&nbsp;|&nbsp;
<a href="/login">Logout</a>

<hr>

<% if (applyMessage != null) { %>
    <p style="color: green; font-weight: bold;"><%= applyMessage %></p>
<% } %>

<h3>Available Jobs</h3>

<% if (jobs == null || jobs.isEmpty()) { %>
    <p>No jobs available right now.</p>
<% } else { %>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Skills Required</th>
        <th>Salary</th>
        <th>Company</th>
        <th>Action</th>
    </tr>

    <% for (Job j : jobs) { %>
    <tr>
        <td><%= j.getJob_id() %></td>
        <td><%= j.getTitle() %></td>
        <td><%= j.getSkill_required() %></td>
        <td><%= j.getSalary() %></td>
        <td><%= j.getCompany() != null ? j.getCompany().getName() : "N/A" %></td>
        <td>
            <a href="/jobseeker/apply?jobId=<%= j.getJob_id() %>">Apply</a>
        </td>
    </tr>
    <% } %>
</table>

<% } %>

</body>
</html>
