<%@ page import="com.zr.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <H1>修改数据</H1>
    <%
        User user= (User) request.getAttribute("user");
    %>
    <form action="UpdateServlet" method="POST">
        <input type="hidden" name="id" value="<%=user.getId()%>">

        name：<input type="text" name="name" value="<%=user.getName()%>">
        <br></br>
        age：<input type="text" name="age" value="<%=user.getAge()%>">
        <br></br>
        tel：<input type="text" name="tel" value="<%=user.getTel()%>">
        <br>
        <input type="submit" value="修改">


    </form>
</center>
</body>
</html>
