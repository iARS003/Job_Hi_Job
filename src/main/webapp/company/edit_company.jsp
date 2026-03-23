<%@ page import="com.ars.jobhijob.entity.Company" %>
<%
    Company company = (Company) request.getAttribute("company");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Company Details</title>
    <link href="https://fonts.googleapis.com/css2?family=Syne:wght@400;600;700;800&family=DM+Sans:wght@300;400;500&display=swap" rel="stylesheet">
    
</head>
<body>

<div class="card">
    <a href="/company/home" class="back-link">Back to Dashboard</a>

    <div class="page-label">Company Profile</div>
    <h1>Edit Details</h1>

    <form action="/company/editCompany" method="post">

        <div class="field">
            <label>Company Name</label>
            <input type="text" name="name"
                   value="<%= company != null && company.getName() != null ? company.getName() : "" %>"
                   placeholder="Your company name" required>
        </div>

        <div class="field">
            <label>Email Address</label>
            <input type="email" name="email"
                   value="<%= company != null && company.getEmail() != null ? company.getEmail() : "" %>"
                   placeholder="company@email.com" required>
        </div>

        <div class="field">
            <label>Phone Number</label>
            <input type="tel" name="phone_no"
                   value="<%= company != null && company.getPhone_no() != null ? company.getPhone_no() : "" %>"
                   placeholder="+91 00000 00000">
        </div>

        <div class="btn-row">
            <a href="/company/home" class="btn-secondary">Cancel</a>
            <button type="submit" class="btn-primary">Save Changes</button>
        </div>

    </form>
</div>

</body>
</html>
