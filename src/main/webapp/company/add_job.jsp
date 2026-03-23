<!DOCTYPE html>
<html>
<head>
    <title>Add Job</title>
</head>
<body>

<h2>Add Job</h2>

<form action="/company/addJob" method="post">

    <input type="text" name="title" placeholder="Job Title" required><br><br>

    <input type="text" name="skill_required" placeholder="Required Skills" required><br><br>

    <input type="number" name="salary" placeholder="Salary" required><br><br>

    <button type="submit">Add Job</button>
</form>

<br>
<a href="/company/home">Back</a>

</body>
</html>