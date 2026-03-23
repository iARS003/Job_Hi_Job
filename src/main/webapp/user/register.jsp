<!DOCTYPE html>
<html>
<head>
<title>Register</title>

<style>
body {
    font-family: Arial;
    background: #eef2f7;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.container {
    background: white;
    padding: 30px;
    border-radius: 10px;
    width: 320px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}
h2 {
    text-align: center;
}
input, select {
    width: 100%;
    padding: 8px;
    margin: 8px 0;
}
button {
    width: 100%;
    padding: 10px;
    background: #28a745;
    color: white;
    border: none;
    border-radius: 5px;
}
a {
    display: block;
    text-align: center;
    margin-top: 10px;
}
</style>

</head>
<body>

<div class="container">
    <h2>Register</h2>

    <form action="/register" method="post">
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>

        <select name="role">
            <option value="JOB_SEEKER">Job Seeker</option>
            <option value="COMPANY">Company</option>
        </select>

        <button type="submit">Sign Up</button>
    </form>

    <a href="/login">Already have an account? Login</a>
</div>

</body>
</html>