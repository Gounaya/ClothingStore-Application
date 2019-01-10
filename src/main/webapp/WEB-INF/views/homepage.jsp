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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" >$(document).ready(function(){
        var productsDiv = $("#product-list");
        var cartDiv = $("#card-list")
        renderProductList(productsDiv);
        refresh();
        function refresh(){
            renderCart(cartDiv);
        }
        function renderProductList(renderingPoint){
            $.ajax({
                url: "http://localhost:8080/product/",
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
            }).done(function(products){
                renderingPoint.empty();
                for(var i = 0; i < products.length; i++){
                    var card = $("<div class='card'>");
                    var image = $('<img class="card-img-top" width="100px" height="199px" src="data:image/png;base64,'+products[i].photo+'"alt="none">');
                    var cardBody = $("<div class='card-body bg-light'><p><h5 class='card-title'>"+products[i].name+"</h5></p><h3>"+products[i].cost+"zł</h3>");
                    var inCardBody = $("<p class='card-text'>"+products[i].describeProduct+"</p><button class='addproduct' data-product-id='"+products[i].id+"'>add to card</button>");
                    card.append(image);
                    cardBody.append(inCardBody);
                    card.append(cardBody);
                    renderingPoint.append(card);
                }
            });
        };
        $("body").on("click", ".addproduct", function(){
            var idProduct = $(this).data("product-id");
            $.ajax({
                url: "http://localhost:8080/cart/"+idProduct,
                type: "POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
            }).done(function(){
                refresh();
            });
        });
        function renderCart(renderingPoint){
            $.ajax({
                url: "http://localhost:8080/cart/",
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
            }).done(function(cart){
                renderingPoint.empty();
                var products = cart.productList;
                var divider = $("<div class='dropdown-divider'>");
                var shoppingCard = $("<a class='dropdown-item' href='/cart/info'>View shoppingcart</a>");
                for(var i = 0; i < products.length; i++){
                    var item = $("<a class='dropdown-item'>"+products[i].name+"</a>");
                    renderingPoint.append(item);
                }
                renderingPoint.append(divider);
                renderingPoint.append(shoppingCard);
            });
        };
    });
    </script>
</head>
<body>
    <jsp:include page="fragments/header.jsp"></jsp:include>
        <div class="container">
            <div id="product-list" class="card-group">
        </div>
    <jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>
