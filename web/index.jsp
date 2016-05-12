<%@ page import="java.util.Set" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <p>
    <%
        Set<String> fileSet = application.getResourcePaths("/");
        Set<String> filterPaths = new HashSet<>();
//        Set<String> filterPaths = fileSet.stream().
//        filter(x -> (x.endsWith(".html") || x.endsWith(".jsp"))).
//        collect(Collectors.toSet());

        int count = 0;
        System.out.println(count);
        application.log("my test");

        filterPaths.addAll(fileSet.stream().
                filter(file -> file.endsWith("html") || file.endsWith("jsp")).
                collect(Collectors.toList()));
    %>
    <%--<%--%>
        <%--for (String path :filterPaths) {--%>
    <%--%>--%>
        <%--<li><%=path%></li>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
    </p>
    <p>file: <%=fileSet.toString()%></p>
    <p>file: <%=filterPaths.toString()%></p>
    <p>${pageContext.servletContext.getResourcePaths("/")}</p>
</body>
</html>
