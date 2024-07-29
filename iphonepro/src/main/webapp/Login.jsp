   <!-- <!DOCTYPE html>
<html>

<head>
    <title>Hello JSP</title>
</head>

<body>
    <h2> please login </h1>
      <form action="login" method="post">
            <table>
                <tr>
                    <td> Username </td>
                    <td> <input type="text" name="username" value=""> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value=""></td>
                </tr>
                <tr>
                    <td><input type="submit" placeholder="submit"></td>
                </tr>
            </table>
        </form>
 -->




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