<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="fragments/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="fragments/headeradmin.jsp"></jsp:include>
<div class="container">
<form:form method = "post" modelAttribute="product" enctype="multipart/form-data">
<div class="container">
    <div class="form-group">
        <label for ="nameId">name:</label>
        <form:input type="text" path="name" id="nameId"/>
        <form:errors path="name" element="div"/>
    </div>
    <div class="form-group">
    <label for ="costId">cost:</label>
    <form:input type="number" path="cost" id="costId"/>
    <form:errors path="cost" element="div"/>
    </div>
        <div class="form-group">
            <label for ="quantityId">quantity:</label>
            <form:input type="number" path="quantity" id="quantityId"/>
            <form:errors path="quantity" element="div"/>
        </div>
    <label for ="describeId">describe:</label>
    <form:input type="text" path="describeProduct" id="describeId"/>
    <form:errors path="describeProduct" element="div"/>
</div>
        <div class="form-group">
    <label for="imageId">Product Image: </label>
    <input type="file" name="image" id="imageId"/>
            </div>
    <button type="submit" class="btn btn-primary">save</button>
    </div>
</form:form>
</body>
</html>
