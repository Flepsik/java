<%--
  Created by IntelliJ IDEA.
  User: Fleps_000
  Date: 18.04.2015
  Time: 18:51
  To change this template use File | Settings | File Templates.
  --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавление Клиента</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<c:url value = '/pages/js/jquery-2.1.3.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value = "/pages/js/jquery.inputmask.js"/>" ></script>
    <script type="text/javascript">// <![CDATA[
    $(document).ready(function() {
        $("#phonemask").inputmask("(999)999-99-99");//маска
    });
    // ]]></script>
</head>
<body>
<h1>Добавление Клиента</h1>
<form:form method="POST" commandName="client" action="${pageContext.request.contextPath}/client/create.html" >
    <table>
        <tbody>
        <tr>
            <td>Имя:</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><form:input path="surname" /></td>
            <td><form:errors path="surname" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>Телефон:</td>
            <td><form:input  id = "phonemask" path="phone"/></td>
            <td><form:errors id = "phonemask" path="phone" cssStyle="color: red;"/></td>
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
<a href="${pageContext.request.contextPath}/client/list.html">Назад</a><br/>
<a href="${pageContext.request.contextPath}/">Главная</a>
</body>
</html>