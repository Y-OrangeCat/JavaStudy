<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2022/9/29     
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test2</title>

  <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.1.js"></script>
  <script>
    $(function (){
      $("#btn").click(function (){
        $.post("${pageContext.request.contextPath}/a2",function (data){
          // console.log(data);
          var  html="";
          for (let i=0;i<data.length;i++){
            html+="<tr>"+
                    "<tr>"+data[i].name+"</tr>"+
                    "<tr>"+data[i].age+"</tr>"+
                    "<tr>"+data[i].sex+"</tr>"+
                    "</tr>"
          }
          $("#content").html(html);
        })
      })
    });
  </script>

</head>
<body>

<input type="button" value="加载数据" id="btn">
<table>
  <tr>
    <td>姓名</td>
    <td>年龄</td>
    <td>性别</td>
  </tr>
  <tbody id="content">
    <%--数据：后台--%>
  </tbody>
</table>

</body>
</html>
