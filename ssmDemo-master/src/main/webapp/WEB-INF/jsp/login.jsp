<%--
  Created by IntelliJ IDEA.
  User: SkyOne
  Date: 2016/10/7
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>登陆界面</title>
<%--<c:url var="url" value="/css/style.css"/>--%>
<%--<link rel="stylesheet" type="text/css" href="${url}">--%>
    <style type="text/css">
        h1,h2,h3,h4,h5,h6,p{padding: 0px;margin:0px}
        div{width:180px; float:left;border:1px solid gray;padding: 6px;}
        div h2{background-color:#000;color:#fff;padding:2px;text-align:center;}
        div p{background:#ddd; padding: 5px}
        div h4, div h3{backgroud:gray;padding: 6px;}
        div span{color:red;}
        p input{width:80px;}
    </style>
</head>
<body>
<h1>${message}</h1>
    <div>
        <c:url var="action" value="/login/login-action1.form" />
        <form action="${action}" method="post">
            <h2>登录</h2>
            <h3><span></span></h3>
            <p>用户：<input type="text" name="name">
            <span>${name1}</span></p>
            <p>密码：<input type="password" name="pwd">
                <span>${pwd1}</span></p>
            <h3><input type="submit" value="Login"></h3>
        </form>
    </div>

    <div>
        <c:url var="action" value="/login/login-action2.form" />
        <form action="${action}" method="post">
            <h2>登录action2</h2>
            <h3><span></span></h3>
            <p>用户：<input type="text" name="name">
                <span>${name2}</span></p>
            <p>密码：<input type="password" name="pwd">
                <span>${pwd2}</span></p>
            <h3><input type="submit" value="Login"></h3>
        </form>
    </div>


    <div>
        <c:url var="action" value="/login/login-action3.form" />
        <form action="${action}" method="post">
            <h2>登录action3</h2>
            <h3><span></span></h3>
            <p>用户：<input type="text" name="name">
                <span>${name3}</span></p>
            <p>密码：<input type="password" name="pwd">
                <span>${pwd3}</span></p>
            <h3><input type="submit" value="Login"></h3>
        </form>
    </div>


    <div>
        <c:url var="action" value="/login/login-action4.form" />
        <form action="${action}" method="post">
            <h2>登录action4</h2>
            <h3><span>${msg4}</span></h3>
            <p>用户：<input type="text" name="name">
                <span>${name4}</span></p>
            <p>密码：<input type="password" name="pwd">
                <span>${pwd4}</span></p>
            <h3><input type="submit" value="Login"></h3>
        </form>
    </div>

    <div>
        <c:url var="action" value="/login/login-action5.form" />
        <form action="${action}" method="post">
            <h2>登录action5</h2>
            <h3><span>${msg5}</span></h3>
            <p>用户：<input type="text" name="name" value="${name}">
                <span>${name5}</span></p>
            <p>密码：<input type="password" name="pwd">
                <span>${pwd5}</span></p>
            <h3><input type="submit" value="Login"></h3>
        </form>
    </div>

    <div>
        <c:url var="action" value="/login/login-action6.form" />
        <form action="${action}" method="post">
            <h2>登录action6</h2>
            <h3><span>${message6}</span></h3>
            <p>用户：<input type="text" name="name" value="${name}">
                <span>${name6}</span></p>
            <p>密码：<input type="password" name="pwd">
                <span>${pwd6}</span></p>
            <h3><input type="submit" value="Login"></h3>
        </form>
    </div>
</body>
</html>
