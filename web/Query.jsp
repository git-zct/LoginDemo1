<%@ page import="com.zr.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
    <title>Title</title>
<style>
    body{
        background-color: black;
    }
</style>
</head>
<body>
    <center>
        <h1><font color="#adff2f">输入要查询的id</font> </h1>>
        <br> <br><br>
        <form action="QueryServlet" method="POST">
            <tr>
            <td><font color="#ff8c00>"><input type="text" name="id"></font><td>
            <td><input type="submit" value="查询"><td>
            <tr>
        </form>

    <center>
</body>
</html>
