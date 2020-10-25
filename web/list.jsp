<%@ page import="com.zr.user.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <title>Insert Title here</title>
    <style>
        body{
            background-color: black;
        }
    </style>
</head>
<body>
    <center>
        <h1><font color="#adff2f">展示全部</font> </h1>>
        <br> <br>
        <table cellpadding="10" cellspacing="0" border="1">
            <font color="#7fff00">
                <td bgcolor="#7fff00">id</td>
                <td bgcolor="#7fff00">name</td>
                <td bgcolor="#7fff00">tel</td>
                <td bgcolor="#7fff00">age</td>
                <td bgcolor="#7fff00"><a href="index.jsp">添加信息</a>><a href="Query.jsp">查询</a></td>

            <%
            List<User> list= (List<User>) request.getAttribute("list");
            if (list==null||list.size()<1){
                out.print("无数据");
            }else {
                for (User user :list){

        %>
            <tr>

                    <td><font color="#ffa07a"><%=user.getId()%></font></td>
                    <td><font color="#ffa07a"><%=user.getName()%></font></td>
                    <td><font color="#ffa07a"><%=user.getTel()%></font></td>
                    <td><font color="#ffa07a"><%=user.getAge()%></font></td>

                <td>
                    <a href="DeleteServlet?id=<%=user.getId()%>">删除</a>
                    <a href="SelectServlet?id=<%=user.getId()%>">修改</a>

                </td>
            </tr>

        <%
                }
            }
        %>


        </table>


    </center>

</body>
</html>
