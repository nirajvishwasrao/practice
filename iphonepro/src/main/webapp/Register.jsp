<!DOCTYPE html>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
    <h1>Hello you got access of register jsp
    </h1>


     <h2> please register </h1>
          <form action="savedetails" method="post">
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
</body>
</html>
