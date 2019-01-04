<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method ="post" modelAttribute="user">


    <label for ="emailId">Email</label>
    <form:input type="email" path="email" id="emailId"/><br><br>

    <label for ="passwordId">password</label>
    <form:input type="password" path="password" id="passwordId"/><br><br>
    <span style="color: red;">${msg}</span>
    <input type="submit" value="save">
</form:form>
</body>
</html>
