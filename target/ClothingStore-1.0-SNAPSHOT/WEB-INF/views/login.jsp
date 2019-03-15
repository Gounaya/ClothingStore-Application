<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="fragments/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
<div class="container">
<form:form method ="post" modelAttribute="user">

    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <form:input type="email" path="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <form:input  type="password" path="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
        <span style="color: red;">${msg}</span>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form:form>
</div>
<jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>
