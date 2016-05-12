<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>登陆界面</title>
</head>
<body>
    <c:choose>
        <c:when test="${param.name == 'admin' && param.passwd == '123456'}">
            <h1>登陆成功</h1>
        </c:when>
        <c:otherwise>
            <h1>登陆失败</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
