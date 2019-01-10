<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
        </ul>
        <jsp:include page="cart.jsp"></jsp:include>
        <div class="btn-group dropleft">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Account
            </button>
            <div class="dropdown-menu">

                <c:if test ="${empty user}">
                    <a class="dropdown-item" href="/register"><button class="btn btn-outline-success" type="button">Register</button></a>
                </c:if>

                <c:if test ="${empty user}">
                    <a class="dropdown-item" href="/login"><button class="btn btn-outline-primary" type="button">Login</button></a>
                </c:if>

                <c:if test ="${not empty user.id}">
                    <a class="dropdown-item" href="/logout">Logout - <c:out value="${user.firstName}"/> </a>
                </c:if>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/cart/info">View shoppingcart</a>
            </div>
        </div>
        <form class="form-inline">
            <c:if test ="${not empty user}">
                <c:if test ="${user.admin == true}">
                    <a class="dropdown-item" href="/admin/"><button class="btn btn-outline-primary" type="button">Admin Panel</button></a></c:if>
            </c:if>
        </form>
    </div>
</nav>

