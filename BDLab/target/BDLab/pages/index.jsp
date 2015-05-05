<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

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
<p>
    <i>${message}</i><br/>
    <a href="${pageContext.request.contextPath}/order/list.html">Все заказы</a><br/>
    <a href="${pageContext.request.contextPath}/client/list.html">Все клиенты</a><br/>
    <a href="${pageContext.request.contextPath}/service/list.html">Все услуги</a><br/>
    <a href="${pageContext.request.contextPath}/position/list.html">Все должности</a><br/>
    <a href="${pageContext.request.contextPath}/worker/list.html">Все сотрудники</a><br/>

</p>
</body>
</html>