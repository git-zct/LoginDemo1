
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
  <h1><font color="#adff2f">添加数据</font> </h1>>
  <br> <br>
  <form action="InsertServlet" method="POST">
    <font color="#adff2f">
      i     d :<input type="text" name="id">
      <br><br>
      name:<input type="text" name="name">
      <br><br>
      a g e  :<input type="text" name="age">
      <br><br>
      t e l    :<input type="text" name="tel">
      <br><br>
      <br>
      <tr>
        <td><input type="submit" value="添加"><td>
        <td><a href="FindServlet">展示所有</a><td>
      </tr>
    </font>
  </form>

</center>>


</body>
</html>
