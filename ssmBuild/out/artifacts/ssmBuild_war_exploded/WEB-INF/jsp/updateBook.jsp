<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <%--    bootstrap CSS--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <%--    栅格系统--%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <input type="hidden" name="bookID" value="${book.bookID}">
            <div class="form-group">
                <label for="bkn">书籍名称：</label>
                <input type="text" id="bkn" class="form-control" name="bookName" value="${book.bookName}" required>
            </div>
            <div class="form-group">
                <label for="bkc">书籍数量：</label>
                <input type="text" id="bkc" class="form-control" name="bookCounts" value="${book.bookCounts}" required>
            </div>
            <div class="form-group">
                <label for="bkd">书籍描述：</label>
                <input type="text" id="bkd" class="form-control" name="detail" value="${book.detail}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
