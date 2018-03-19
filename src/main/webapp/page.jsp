<html>
    <head>
        <title>Java deserialization example</title>
    </head>
    <body>
        <h2>Logged in as <%= request.getAttribute("name") %></h2>
        <form action="/" method="POST">
            Change your login: <input type="text" name="name" />
            <input type="submit"/>
        </form>
    </body>
</html>