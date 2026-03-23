<%@ page import="com.ars.jobhijob.entity.Job" %>
<%
    Job job = (Job) request.getAttribute("job");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Job</title>
</head>
<body>

<h2>Edit Job</h2>

<form action="/company/updateJob" method="post">

    <input type="hidden" name="job_id" value="${job.job_id}">

    <input type="text" name="title" value="${job.title}"><br><br>

    <input type="text" name="skill_required" value="${job.skill_required}"><br><br>

    <input type="number" name="salary" value="${job.salary}"><br><br>

    <button type="submit">Update</button>
</form>

</body>
</html>