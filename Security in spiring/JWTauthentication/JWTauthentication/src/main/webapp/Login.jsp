   <!DOCTYPE html>
<html>

<head>
    <title>Hello JSP</title>
</head>

<body>




        <!-- login.jsp -->
        <form action="/login" method="post">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <button type="submit">Login</button>
            </div>
        </form>

</body>

</html>