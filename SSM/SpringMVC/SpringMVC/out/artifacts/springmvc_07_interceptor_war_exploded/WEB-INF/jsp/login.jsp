<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2022/9/30     
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<%--在web-inf下面的所有页面或者资源，只能通过controller或者Servlet进行访问--%>
<h1>用户登录页</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名：<input type="text" name="username">
    密  码：<input type="text" name="password">
    <input type="submit" value="登录">
</form>

</body>
</html>
