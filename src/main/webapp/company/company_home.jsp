<%@ page import="com.ars.jobhijob.entity.Company" %>
<%
    Company company = (Company) session.getAttribute("company");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard — <%= company != null ? company.getName() : "Company" %></title>
</head>
<body>

    <table width="100%" cellpadding="4" cellspacing="0">
        <tr>
            <td><b>Job Hi Job</b></td>
            <td align="right"><a href="/login">Logout</a></td>
        </tr>
    </table>

    <hr>

    <p><small>Company Dashboard</small></p>
    <h1>Welcome back, <%= company != null ? company.getName() : "Company" %></h1>

    <hr>

    <% if (company != null) { %>
    <table cellpadding="8" cellspacing="0" border="1" width="60%">
        <tr>
            <td width="50" align="center" valign="middle">
                <b>
                    <%= company.getName() != null && !company.getName().isEmpty()
                        ? String.valueOf(company.getName().charAt(0)).toUpperCase()
                        : "C" %>
                </b>
            </td>
            <td valign="middle">
                <b><%= company.getName() %></b><br>
                <% if (company.getEmail() != null && !company.getEmail().isEmpty()) { %>
                    &bull; <%= company.getEmail() %><br>
                <% } %>
                <% if (company.getPhone_no() != null && !company.getPhone_no().isEmpty()) { %>
                    &bull; <%= company.getPhone_no() %>
                <% } %>
            </td>
            <td align="right" valign="middle">
                <a href="/company/editCompany">Edit Detail</a>
            </td>
        </tr>
    </table>
    <% } %>

    <br>

    <table cellpadding="12" cellspacing="8" width="60%">
        <tr>
            <td width="50%" valign="top">
                <table cellpadding="8" border="1" width="100%">
                    <tr>
                        <td>
                            <small>Post New</small><br>
                            <b><a href="/company/addJob">Add Job</a></b><br>
                            Create a new job listing and start receiving applications from top candidates.
                        </td>
                    </tr>
                </table>
            </td>
            <td width="50%" valign="top">
                <table cellpadding="8" border="1" width="100%">
                    <tr>
                        <td>
                            <small>Manage</small><br>
                            <b><a href="/company/viewJobs">View Jobs</a></b><br>
                            Browse, edit, or remove your active job listings from one place.
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</body>
</html>