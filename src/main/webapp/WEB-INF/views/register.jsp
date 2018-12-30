<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method = "post" modelAttribute="user">

    <label for ="firstNameId">firstname</label>
    <form:input type="text" path="firstName" id="firstNameId"/><br><br>
    <form:errors path="firstName" element="div"/><br><br>


    <label for ="lastNameId">lastname</label>
    <form:input type="text" path="lastName" id="lastNameId"/><br><br>
    <form:errors path="lastName" element="div"/><br><br>


    <label for ="passwordId">password</label>
    <form:input type="password" path="password" id="passwordId"/><br><br>
    <form:errors path="password" element="div"/><br><br>

    <label for ="emailId">Email</label>
    <form:input type="email" path="email" id="emailId"/><br><br>
    <form:errors path="email" element="div"/><br><br>

    <input type="submit" value="save">
</form:form>
</body>
</html>