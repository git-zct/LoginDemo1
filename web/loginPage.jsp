<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        body{
            background-color: black;
        }
    </style>
</head>
<body>
<center>
    <br><br>
    <h1><font color="#adff2f">登录页面</font></h1>
    <br>
    <%--  提交表单后跳转到login页面(在web.xml中定义)，鼠标悬停在/login上自动提示要使用绝对路径，直接转化就行--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <font color="#adff2f">username:</font><input name="username" type="text">
        <br><br>
        <font color="#adff2f">password:</font><input name="password" type="password">
        <br><br>
        <td><%="     "%></td><input  type="submit" value="login">
    </form>
</center>
</body>
</html>
