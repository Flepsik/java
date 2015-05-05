<%--
  Created by IntelliJ IDEA.
  User: Fleps_000
  Date: 16.04.2015
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Position list page</title>
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
<h1>Список должностей</h1>
<i>${message}</i><br/>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="25px">ID</th>
        <th width="150px">Название</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="position" items="${positionList}">
        <tr>
            <td>${position.id}</td>
            <td>${position.name}</td>
            <td><a href="${pageContext.request.contextPath}/position/edit/${position.id}.html">Редактировать</a><br/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<form:form method="POST" commandName="position" action="${pageContext.request.contextPath}/position/create.html" >
    <table>
        <tbody>
        <tr>
            <td>Введите название новой должности:<br/></td>

        </tr>
        <tr>
            <td><form:input path="name" /><input type="submit" value="Добавить" /></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>

