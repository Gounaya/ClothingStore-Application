<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="fragments/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
<div class="container">
<form:form method = "post" modelAttribute="user">
    <div class="container">
    <div class="form-group">
        <label for ="firstNameId">firstname</label>
        <form:input type="text" path="firstName" id="firstNameId"/>
        <form:errors path="firstName" element="div"/>
    </div>
    <div class="form-group">
        <label for ="lastNameId">lastname</label>
        <form:input type="text" path="lastName" id="lastNameId"/>
        <form:errors path="lastName" element="div"/>
    </div>
    <div class="form-group">
        <label for ="passwordId">password</label>
        <form:input type="password" path="password" id="passwordId"/>
        <form:errors path="password" element="div"/>
    </div>
    <div class="form-group">
        <label for ="emailId">Email</label>
        <form:input type="email" path="email" id="emailId"/>
        <form:errors path="email" element="div"/>
        <span style="color:red">${msg}</span>
    </div>
    <div class="form-group">
        <form:radiobutton path="gender" value="M"/>Male
        <form:radiobutton path="gender" value="F"/>Female
    </div>
    <div class="form-group">
        <label for ="newsId">Newsletter</label>
        <form:checkbox path="newsletter" id="newsId"/>
        <form:errors path="newsletter" element="div"/>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form:form>
</div>
<jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>