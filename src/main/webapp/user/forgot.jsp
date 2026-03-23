<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>

<style>
body {
    font-family: Arial;
    background: #f8f9fa;
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
input {
    width: 100%;
    padding: 8px;
    margin: 10px 0;
}
button {
    width: 100%;
    padding: 10px;
    background: #ffc107;
    border: none;
    border-radius: 5px;
}
.error {
    color: red;
    text-align: center;
}
</style>

</head>
<body>

<div class="container">
    <h2>Forgot Password</h2>

    <form action="/forgot" method="post">
        <input type="text" name="username" placeholder="Enter Username" required>
        <input type="password" name="password" placeholder="Enter New Password" required>
	    <button type="submit">Update Password</button>
    </form>

    <div class="error">${error}</div>
</div>

</body>
</html>