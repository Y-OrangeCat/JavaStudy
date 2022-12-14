<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
</div>

<%--<form action="${pageContext.request.contextPath}/book/addBook" method="post">
    书籍id：<input type="text" name="bookID"><br/><br/>
    书籍名称：<input type="text" name="bookName"><br/><br/>
    书籍数量：<input type="text" name="bookCount"><br/><br/>
    书籍详情：<input type="text" name="detail"><br/><br/>
    <input type="submit" value="增加">
</form>--%>

<form action="${pageContext.request.contextPath}/book/addBook" method="post">
    <div class="col-md-4 column">
        <div class="form-group">
            <label>书籍名称：</label>
            <input type="text" name="bookName" class="form-control" required>
        </div>
        <div class="form-group">
            <label>书籍数量：</label>
            <input type="text" name="bookCounts" class="form-control" required>
        </div>
        <div class="form-group">
            <label>书籍详情：</label>
            <input type="text" name="detail" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-default">提交</button>
    </div>
</form>

</body>
</html>
