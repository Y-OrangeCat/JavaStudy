<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2022/9/19     
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
        h3 {
            width: 280px;
            height: 58px;
            margin: 100px auto;
            text-align: center;
            line-height: 58px;
            background: deepskyblue;
            border-radius: 10px;
        }
    </style>
</head>
<body>


<%--绝对地址 ${pageContext.request.contextPath}/book/allBook--%>
<h3>
    <a href="${pageContext.request.contextPath}/book/allBook">点击跳转到书籍展示页</a>
</h3>

</body>
</html>
