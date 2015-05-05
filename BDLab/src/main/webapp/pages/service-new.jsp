<%--
  Created by IntelliJ IDEA.
  User: Fleps_000
  Date: 19.04.2015
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New service page</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Добавление услуги</h1>
<form:form method="POST" commandName="service" action="${pageContext.request.contextPath}/service/create.html" >
    <table>
        <tbody>
        <tr>
            <td>Название:</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>Стоимость:</td>
            <td><form:input path="price" /></td>
            <td><form:errors path="price" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Добавить" />
</form:form>
<a href="${pageContext.request.contextPath}/service/list.html">Назад</a><br/>
<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>