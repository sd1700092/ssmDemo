<%--
  Created by IntelliJ IDEA.
  User: SkyOne
  Date: 2016/10/6
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件上传演示</title>
</head>
<body>
    <h2>文件上载</h2>
    <h3>${error}</h3>
    <c:url var="url" value="/upload/file-upload.form"></c:url>
    <form action="${url}" method="post" enctype="multipart/form-data">
        图片：<input type="file" name="image"><br>
        作者：<input type="text" name="author"><br>
        <input type="submit" value="上载图片">
    </form>
</body>
</html>
