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
    <title>主页</title>
</head>
<body>
<h1>主页</h1>
<span>用户名：${username}</span>
<span>密 码：${password}</span>

<p><a href="${pageContext.request.contextPath}/user/goOut">注销</a></p>
</body>
</html>
