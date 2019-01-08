<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <!-- <div class="container-fluid">
      Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">You Shop Name</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Category one <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Category two</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="glyphicon glyphicon-shopping-cart"></span> ${mycart.quantityProductCart} - Items<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-cart" role="menu">
                        <c:forEach items="${mycart.productList}" var="product">
                        <li>
                  <span class="item">
                    <span class="item-left">
                        <img width="50px" height="50px" src="data:image/png;base64, ${product.photo}" alt="none">
                        <span class="item-info">
                            <span>${product.name}</span>
                            <span>${product.cost}zl</span>
                        </span>
                    </span>
                    <span class="item-right">
                        <button class="btn btn-xs btn-danger pull-right">x</button>
                    </span>
                </span>
                        </li>
                        </c:forEach>
                        <li class="divider"></li>
                        <li><a class="text-center" href="/cart/info">View My Cart</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    <!--  </div> /.container-fluid -->
</nav>