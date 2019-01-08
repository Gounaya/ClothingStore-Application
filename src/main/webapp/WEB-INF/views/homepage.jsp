<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>ClothingStore - Mateusz Lasota</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="fragments/head.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="fragments/header.jsp"></jsp:include>
        <div class="container">
            hi : ${user.firstName} | user id: ${user.id} | koszyk id:_ ${user.cart.id}
            <div class="card-group">
                <c:forEach items="${products}" var="product">
                <div class="card">
                    <img class="card-img-top"
                         width="150px" height="199px"
                         src="data:image/png;base64, ${product.photo}"
                         alt="none">
                    <div class="card-body bg-light">
                        <p><h5 class="card-title">${product.name}</h5><h3>${product.cost}zł</h3> </p>
                        <p class="card-text">opissssssss</p>
                        <a href="#" class="btn btn-primary">Add to Card</a>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    <jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>
