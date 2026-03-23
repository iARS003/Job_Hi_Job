<%@ page import="com.ars.jobhijob.entity.JobSeeker" %>
<%
    JobSeeker js = (JobSeeker) request.getAttribute("jobSeeker");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>

<h2>Edit Profile</h2>

<form action="/jobseeker/editProfile" method="post">

    <label>Name:</label><br>
    <input type="text" name="name"
           value="<%= js != null && js.getName() != null ? js.getName() : "" %>"
           required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email"
           value="<%= js != null && js.getEmail() != null ? js.getEmail() : "" %>"
           required><br><br>

    <label>Phone Number:</label><br>
    <input type="tel" name="phone_no"
           value="<%= js != null && js.getPhone_no() != null ? js.getPhone_no() : "" %>"><br><br>

    <label>Skills (comma separated):</label><br>
    <input type="text" name="skills"
           value="<%= js != null && js.getSkills() != null ? js.getSkills() : "" %>"><br><br>

    <label>Experience (years):</label><br>
    <input type="number" name="experience"
           value="<%= js != null ? js.getExperience() : 0 %>"
           min="0"><br><br>

    <button type="submit">Save Changes</button>
    &nbsp;
    <a href="/jobseeker/home">Cancel</a>

</form>

</body>
</html>
