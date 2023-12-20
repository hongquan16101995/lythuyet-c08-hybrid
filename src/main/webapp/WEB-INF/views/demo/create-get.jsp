<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/19/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/api/demo" method="post">
    <h1>PostMapping</h1>
    <input type="text" name="name">
    <button type="submit">Create1</button>
</form>
<form action="/api/demo/create" method="post">
    <h1>RequestMapping</h1>
    <input type="text" name="name">
    <button type="submit">Create1</button>
</form>
</body>
</html>
