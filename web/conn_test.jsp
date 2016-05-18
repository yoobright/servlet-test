<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="db" class="cc.test.DbBean"/>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>conn test</title>
</head>
<body>
    <div><%=db.getDataSource()%></div><br>
    <c:choose>
        <c:when test="${db.connectionOK}">连接成功</c:when>
        <c:otherwise>连接失败</c:otherwise>
    </c:choose>
</body>
</html>
