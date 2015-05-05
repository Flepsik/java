<%--
  Created by IntelliJ IDEA.
  User: Fleps_000
  Date: 19.04.2015
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order list page</title>
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
<h1>Список заказов</h1>
<i>${message}</i><br/>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <a href="${pageContext.request.contextPath}/order/create.html">Добавить заказ</a><br/>
    <tr>
        <th>ID</th>
        <th>Клиент</th>
        <th>Услуга</th>
        <th>Сотрудник</th>
        <th>Дата</th>
        <th>Цена</th>
        <th>Статус</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.id}</td>
            <td>${order.client.name} ${order.client.surname}</td>
            <td>${order.service.name}</td>
            <td>${order.worker.name} ${order.worker.surname}</td>
            <td>${order.date}</td>
            <td>${order.service.price}</td>
            <td>
                <c:choose>
                    <c:when test="${order.status == 'true'}">
                        Активен
                    </c:when>
                    <c:when test="${order.status == 'false'}">
                        Завершен
                    </c:when>
                </c:choose>
            </td>
            <td>
                <c:if test = "${order.status == true}">
                    <a href="${pageContext.request.contextPath}/order/edit-status/${order.id}.html">Завершить</a><br/>
                </c:if>
                <a href="${pageContext.request.contextPath}/order/delete/${order.id}.html">Удалить</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>

