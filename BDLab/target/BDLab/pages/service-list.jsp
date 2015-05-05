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
    <title>Список услуг</title>
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
<h1>Список услуг</h1>
<i>${message}</i><br/>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="25px">ID</th>
        <th width="150px">Имя</th>
        <th width="100px">Цена</th>
        <th width="100px">Статус</th>
        <th width="50px">Действия</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="service" items="${serviceList}">
        <tr>
            <td>${service.id}</td>
            <td>${service.name}</td>
            <td>${service.price}</td>
            <td>
                <c:choose>
                    <c:when test="${service.status == 'true'}">
                        Активный
                    </c:when>
                    <c:when test="${service.status == 'false'}">
                        Неактивный
                    </c:when>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/service/edit/${service.id}.html">Редактировать</a><br/>
                <a href="${pageContext.request.contextPath}/service/edit-status/${service.id}.html">Изменить статус</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/service/create.html">Добавить услугу</a><br/>

<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>
