<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2022/9/30     
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" value="upload">
  </form>

  <%--这个链接只查看/static/mv.jpg，并不下载--%>
  <a href="${pageContext.request.contextPath}/static/mv.jpg">点击下载</a>

  </body>
</html>
