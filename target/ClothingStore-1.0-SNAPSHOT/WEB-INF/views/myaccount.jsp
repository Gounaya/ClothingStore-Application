<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>MyAccout Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="fragments/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
<div class="container">

    ${user.firstName} :DDDDD
</div>
<jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>