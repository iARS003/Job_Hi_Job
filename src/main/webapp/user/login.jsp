<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<style>
body {
    font-family: Arial;
    background: #f4f6f9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.container {
    background: white;
    padding: 30px;
    border-radius: 10px;
    width: 300px;
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
    background: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
}
a {
    display: block;
    text-align: center;
    margin-top: 10px;
}
.error {
    color: red;
    text-align: center;
}
</style>

</head>
<body>

<div class="container">
    <h2>Login</h2>

    <form action="/login" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>

    <div class="error">${error}</div>

    <a href="/register">Create Account</a>
    <a href="/forgot">Forgot Password?</a>
</div>

</body>
</html>