<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method = "post" modelAttribute="product" enctype="multipart/form-data">

    <label for ="nameId">name:</label>
    <form:input type="text" path="name" id="nameId"/><br><br>
    <form:errors path="name" element="div"/><br><br>


    <label for ="costId">cost:</label>
    <form:input type="number" path="cost" id="costId"/><br><br>
    <form:errors path="cost" element="div"/><br><br>


    <label for ="quantityId">cost:</label>
    <form:input type="number" path="quantity" id="quantityId"/><br><br>
    <form:errors path="quantity" element="div"/><br><br>

    <label for="imageId">Product Image: </label>
    <input type="file" name="image" id="imageId"/>

    <input type="submit" value="save">
</form:form>
</body>
</html>
