<!DOCTYPE html>
<html>
<head>
<title>Job Hi Job</title>

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    background: white;
    padding: 40px;
    border-radius: 12px;
    text-align: center;
    width: 350px;
    box-shadow: 0 0 20px rgba(0,0,0,0.2);
}

h1 {
    margin-bottom: 10px;
    color: #333;
}

p {
    color: #666;
    margin-bottom: 25px;
}

button {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: none;
    border-radius: 6px;
    font-size: 16px;
    cursor: pointer;
}

.login-btn {
    background-color: #007bff;
    color: white;
}

.register-btn {
    background-color: #28a745;
    color: white;
}

button:hover {
    opacity: 0.9;
}
</style>

</head>
<body>

<div class="container">
    <h1>Welcome to <br>Job hi Job</h1>
    <p>Your gateway to jobs and hiring</p>

    <form action="/login">
        <button class="login-btn">Login</button>
    </form>

    <form action="/register">
        <button class="register-btn">Register</button>
    </form>
</div>

</body>
</html>