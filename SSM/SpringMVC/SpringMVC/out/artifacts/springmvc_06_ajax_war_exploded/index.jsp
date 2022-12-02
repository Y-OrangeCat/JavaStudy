<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2022/9/29     
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%--导入jquery，可以使用在线的CDN，也可以下载导入--%>
    <%--<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.1.js"></script>

    <script>
      function a1(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{'name':$("#txtName").val()},
          success:function (data,status) {
            console.log("data="+data);
            console.log("status:"+status);
          },
          error:function (){

          }
        });
      }
    </script>

  </head>
  <body>

  <%--失去焦点的时候，发起一个请求到后台--%>
  用户名：<input type="text" id="txtName" onblur="a1()">

  </body>
</html>
