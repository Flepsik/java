<%--
  Created by IntelliJ IDEA.
  User: Fleps_000
  Date: 19.04.2015
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редактирование сотрудника</title>
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
<h1>Редактирование данных сотрудника</h1>
<form:form method="POST" commandName="worker" action="${pageContext.request.contextPath}/worker/edit/${worker.id}.html">
    <table>
        <tbody>
        <tr>
            <td>Имя:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><form:input path="surname"/></td>
            <td><form:errors path="surname" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>Отчество:</td>
            <td><form:input path="patromymic"/></td>
            <td><form:errors path="patromymic" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>Должность:</td>
            <td><form:select path="position">
                <form:option value="${worker.position.id}">${worker.position.name}</form:option>
                <c:forEach items="${positions}" var="positions">
                    <c:if test="${worker.position.id != positions.id}">
                        <form:option value="${positions.id}">${positions.name}</form:option>
                    </c:if>
                </c:forEach>
            </form:select>
                <form:errors path="position" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Заработная плата:</td>
            <td><form:input path="salary"/></td>
            <td><form:errors path="salary" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Изменить"/>
</form:form>
<a href="${pageContext.request.contextPath}/worker/list.html">Назад</a><br/>
<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>