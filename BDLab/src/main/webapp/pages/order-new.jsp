<%--
  Created by IntelliJ IDEA.
  User: Fleps_000
  Date: 18.04.2015
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новый заказ</title>
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
<h1>Новый заказ</h1>
<form:form method="POST" commandName="order" action="${pageContext.request.contextPath}/order/create.html" >
    <table>
        <tbody>
        <tr>
            <td>Клиент:</td>
            <td><form:select path="client">
                <c:forEach items="${clients}" var="clients">
                    <form:option value="${clients.id}">${clients.name} ${clients.surname}</form:option>
                </c:forEach>
            </form:select>
                <form:errors path="client" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Услуга:</td>
            <td><form:select path="service">
                <c:forEach items="${services}" var="services">
                    <c:if test="${services.status == true}">
                        <form:option value="${services.id}">${services.name}</form:option>
                    </c:if>
                </c:forEach>
            </form:select>
                <form:errors path="service" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Сотрудник:</td>
            <td><form:select path="worker">
                <c:forEach items="${workers}" var="workers">
                    <c:if test="${workers.status == true}">
                        <form:option value="${workers.id}">
                        ${workers.name} ${workers.surname} (${workers.position.name})
                        </form:option>
                    </c:if>
                </c:forEach>
            </form:select>
                <form:errors path="worker" cssClass="error"/>
            </td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Добавить" />
</form:form>
<a href="${pageContext.request.contextPath}/order/list.html">Назад</a><br/>
<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>