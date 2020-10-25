<%@ page import="com.zr.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
    <title>Insert title here</title>
    <style>
        body{
            background-color: black;
        }
    </style>
</head>
<body>
<center>
    <%
        User user= (User) request.getAttribute("user");
        if(user==null||user.getName()==null){

            out.print("查无此人！");
        }else{


    %>
    <center>
        <h1><font color="#adff2f">id为<%=user.getId()%>的信息为<font><h1>

    <table cellpadding="1" cellspacing="1" border="1" >
        <tr>
            <font color="#ff8c00" size="5">
            <td>i  d<td>
            <td><%=user.getId()%><td>
            <font>

        <tr>
        <tr>
            <font color="#ff8c00" size="5">
                <td>姓名<td>
                <td><%=user.getName()%><td>
            <font>
        <tr>
        <tr>
                <td>电话<td>
                <td><%=user.getTel()%><td>
        <tr>
        <tr>
                <td>年龄<td>
                 <td><%=user.getAge()%><td>
        <tr>
        <br>
        <a href="FindServlet">查询</a>
<tr>
       <a href="DeleteServlet?id=<%=user.getId()%>">删除</a>
       <a href="SelectServlet?id=<%=user.getId()%>">修改</a>
<tr>
        <%}%>
    </table>
    </center>
</body>
</html>
